"""
题目详情拉取模块

根据题目列表 CSV，并发拉取每道题目的详情信息（题目描述、示例、Java 参考代码等），
保存为题目详情 CSV 文件。
"""
import csv
import json
import os
import re
import threading
import time
import urllib.request
from concurrent.futures import ThreadPoolExecutor, as_completed

from env_utils import CONCURRENCY, COOKIE, HEADERS, LIST_CSV, OUTPUT_DIR, DETAIL_CSV

OUTPUT_CSV = DETAIL_CSV  # 题目详情输出文件

CSV_COLUMNS = [
    "questionFrontendId", "questionTitle", "translatedTitle", "titleSlug", "url",
    "difficulty", "categoryTitle", "topicTags", "content", "translatedContent",
    "status", "isPaidOnly", "likes", "acRate", "similarQuestions",
    "codeSnippets", "javaCode", "exampleTestcases",
]

print_lock = threading.Lock()


def fetch_detail(title_slug: str, retries: int = 3) -> dict:
    """
    获取单道题目的详情数据

    Args:
        title_slug: 题目的 titleSlug（如 "two-sum"）
        retries: 失败重试次数

    Returns:
        题目详情数据字典
    """
    url = f"https://leetcode.cn/problems/{title_slug}/description/"
    for attempt in range(retries):
        req = urllib.request.Request(url, headers=HEADERS)
        try:
            with urllib.request.urlopen(req) as resp:
                html = resp.read().decode("utf-8")
            return parse_html(html, title_slug)
        except Exception as e:
            if attempt < retries - 1:
                wait = 3 * (attempt + 1)
                time.sleep(wait)
            else:
                raise


def parse_html(html: str, title_slug: str) -> dict:
    """
    从页面 HTML 中解析出题目详情 JSON 数据

    Args:
        html: 页面 HTML 内容
        title_slug: 题目的 titleSlug（用于错误提示）

    Returns:
        题目详情数据字典
    """
    match = re.search(
        r'<script id="__NEXT_DATA__" type="application/json">(.*?)</script>',
        html, re.DOTALL,
    )
    if not match:
        raise ValueError("未找到 __NEXT_DATA__ JSON")

    data = json.loads(match.group(1))
    queries = data["props"]["pageProps"]["dehydratedState"]["queries"]
    for q in queries:
        if q["queryKey"] and q["queryKey"][0] == "questionDetail":
            return q["state"]["data"]["question"]
    raise ValueError("未找到 questionDetail 查询")


def parse_question(q: dict) -> list:
    """
    将题目详情数据解析为 CSV 行列表

    Args:
        q: 题目详情数据字典

    Returns:
        按 CSV_COLUMNS 顺序排列的字段列表
    """
    tags = q.get("topicTags") or []
    tag_names = ";".join(t.get("translatedName") or t.get("name", "") for t in tags)

    stats = json.loads(q.get("stats", "{}"))
    ac_rate = stats.get("acRate", "")

    snippets = q.get("codeSnippets") or []
    java_code = next(
        (s["code"] for s in snippets if s["langSlug"] == "java"), "",
    )

    return [
        q["questionFrontendId"],
        q["questionTitle"],
        q.get("translatedTitle", ""),
        q["titleSlug"],
        f"https://leetcode.cn/problems/{q['titleSlug']}/description/",
        q["difficulty"],
        q.get("categoryTitle", ""),
        tag_names,
        q.get("content", ""),
        q.get("translatedContent", ""),
        q.get("status") or "NOT_STARTED",
        q["isPaidOnly"],
        q.get("likes", 0),
        ac_rate,
        q.get("similarQuestions", ""),
        json.dumps(snippets, ensure_ascii=False),
        java_code,
        q.get("exampleTestcases", ""),
    ]


def fetch_one(index: int, total: int, row: dict):
    slug = row["titleSlug"]
    frontend_id = row["frontendId"]
    title = row.get("translatedTitle") or row.get("title", "")

    try:
        question = fetch_detail(slug)
        result = (index, parse_question(question), None)
    except Exception as e:
        result = (index, None, str(e))

    with print_lock:
        if result[2]:
            print(f"  [{index}/{total}] #{frontend_id} {title} - FAIL: {result[2]}")
        else:
            print(f"  [{index}/{total}] #{frontend_id} {title} - OK")

    return result


def main():
    with open(LIST_CSV, "r", encoding="utf-8-sig") as f:
        reader = csv.DictReader(f)
        problems = list(reader)

    total = len(problems)
    print(f"共 {total} 题，并发数: {CONCURRENCY}")

    os.makedirs(OUTPUT_DIR, exist_ok=True)

    all_results = {}
    success = 0
    failed = 0

    with ThreadPoolExecutor(max_workers=CONCURRENCY) as executor:
        futures = {
            executor.submit(fetch_one, i, total, row): i
            for i, row in enumerate(problems, 1)
        }
        for future in as_completed(futures):
            index, row_data, error = future.result()
            all_results[index] = (row_data, error)

    with open(OUTPUT_CSV, "w", newline="", encoding="utf-8-sig") as f:
        writer = csv.writer(f)
        writer.writerow(CSV_COLUMNS)
        for i in range(1, total + 1):
            row_data, error = all_results.get(i, (None, "未处理"))
            if row_data:
                writer.writerow(row_data)
                success += 1
            else:
                failed += 1

    print(f"\n完成！成功 {success}，失败 {failed}，已保存到: {OUTPUT_CSV}")


if __name__ == "__main__":
    main()
