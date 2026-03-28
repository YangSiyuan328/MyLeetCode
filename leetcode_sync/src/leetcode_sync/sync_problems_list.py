"""
题目列表同步模块

从 LeetCode CN GraphQL API 拉取题目列表，保存为 CSV 文件，
并与历史备份对比，输出变化情况。
"""
import csv
import json
import os
import time
import urllib.request

from env_utils import DATA_DIR, GRAPHQL_QUERY, HEADERS, LIMIT, LIST_CSV, MAX_FETCH, OUTPUT_DIR, URL

OUTPUT = LIST_CSV  # 题目列表输出文件

CSV_COLUMNS = [
    "id", "frontendId", "title", "translatedTitle",
    "difficulty", "status", "paidOnly", "acRate",
    "isInMyFavorites", "titleSlug", "url", "topicTags",
]


def fetch_page(skip: int, retries: int = 3) -> dict:
    """
    从 LeetCode API 获取一页题目列表

    Args:
        skip: 跳过的记录数（分页偏移）
        retries: 失败重试次数

    Returns:
        API 返回的 JSON 数据字典
    """
    payload = {
        "query": GRAPHQL_QUERY,
        "variables": {"skip": skip, "limit": LIMIT},
    }
    for attempt in range(retries):
        req = urllib.request.Request(
            URL,
            data=json.dumps(payload).encode("utf-8"),
            headers=HEADERS,
            method="POST",
        )
        try:
            with urllib.request.urlopen(req) as resp:
                return json.loads(resp.read().decode("utf-8"))
        except Exception as e:
            if attempt < retries - 1:
                wait = 3 * (attempt + 1)
                print(f"  请求失败，{wait}s 后重试 ({attempt + 1}/{retries}): {e}")
                time.sleep(wait)
            else:
                raise


def parse_question(q: dict) -> list:
    """
    将 API 返回的题目数据解析为 CSV 行列表

    Args:
        q: API 返回的单个题目数据

    Returns:
        按 CSV_COLUMNS 顺序排列的字段列表
    """
    tags = q.get("topicTags") or []
    tag_names = ";".join(t.get("nameTranslated") or t.get("name", "") for t in tags)
    return [
        q["id"],
        q["questionFrontendId"],
        q["title"],
        q.get("translatedTitle", ""),
        q["difficulty"],
        q.get("status") or "NOT_STARTED",
        q["paidOnly"],
        q["acRate"],
        q["isInMyFavorites"],
        q["titleSlug"],
        f"https://leetcode.cn/problems/{q['titleSlug']}/description/",
        tag_names,
    ]


def load_csv_as_dict(filepath: str) -> dict:
    """读取 CSV 文件，以 frontendId 为 key 返回字典"""
    if not os.path.exists(filepath):
        return {}
    with open(filepath, "r", encoding="utf-8-sig") as f:
        reader = csv.DictReader(f)
        return {row["frontendId"]: row for row in reader}


def find_latest_bak_file() -> str | None:
    """查找 data 目录下最新的题目列表备份文件"""
    if not os.path.exists(DATA_DIR):
        return None
    bak_files = [f for f in os.listdir(DATA_DIR) if f.startswith("题目列表_") and f.endswith(".csv")]
    if not bak_files:
        return None
    # 按文件名排序，取最大的（最新日期）
    bak_files.sort()
    return os.path.join(DATA_DIR, bak_files[-1])


def compare_with_bak(new_file: str, bak_file: str) -> None:
    """对比新数据和备份数据，输出变化情况"""
    new_data = load_csv_as_dict(new_file)
    bak_data = load_csv_as_dict(bak_file)

    new_count = len(new_data)
    bak_count = len(bak_data)

    # 新增的题目
    added = [fid for fid in new_data if fid not in bak_data]
    if added:
        print(f"\n总数变化: {bak_count} → {new_count} (新增 {len(added)} 题)")
        print(f"新增题目 ({len(added)} 题):")
        for fid in sorted(added):
            row = new_data[fid]
            print(f"  + [{fid}] {row.get('translatedTitle') or row['title']}")

    # 删除的题目
    removed = [fid for fid in bak_data if fid not in new_data]
    if removed:
        print(f"\n总数变化: {bak_count} → {new_count} (减少 {len(removed)} 题)")
        print(f"删除题目 ({len(removed)} 题):")
        for fid in sorted(removed):
            row = bak_data[fid]
            print(f"  - [{fid}] {row.get('translatedTitle') or row['title']}")

    # 内容变化的题目
    changed = {}  # {frontendId: [变化的字段列表]}
    for fid in new_data:
        if fid in bak_data:
            new_row = new_data[fid]
            bak_row = bak_data[fid]
            changed_cols = []
            # 比较每个字段（排除可能变化的字段如 status, acRate）
            for col in CSV_COLUMNS:
                if col in ("status", "acRate"):
                    continue  # 状态和通过率可能因用户刷题而变化，不计入
                if str(new_row.get(col, "")) != str(bak_row.get(col, "")):
                    changed_cols.append(col)
            if changed_cols:
                changed[fid] = changed_cols

    if changed:
        print(f"内容变化 ({len(changed)} 题):")
        for fid in sorted(changed.keys()):
            new_row = new_data[fid]
            cols = ", ".join(changed[fid])
            print(f"  * [{fid}] {new_row.get('translatedTitle') or new_row['title']} ({cols})")

    # 如果没有任何变化
    if not added and not removed and not changed:
        print(f"\n官方数据没有变化，共 {new_count} 题")


def main():
    skip = 0
    page = 1
    fetched = 0

    os.makedirs(OUTPUT_DIR, exist_ok=True)

    with open(OUTPUT, "w", newline="", encoding="utf-8-sig") as f:
        writer = csv.writer(f)
        writer.writerow(CSV_COLUMNS)

        while True:
            print(f"正在获取第 {page} 页 (skip={skip})...")
            data = fetch_page(skip)

            result = data.get("data", {}).get("problemsetQuestionListV2")
            if not result:
                print("请求失败:")
                print(json.dumps(data, indent=2, ensure_ascii=False))
                break

            total = result["totalLength"]
            questions = result["questions"]
            has_more = result["hasMore"]

            if MAX_FETCH:
                remaining = MAX_FETCH - fetched
                if remaining < len(questions):
                    questions = questions[:remaining]

            print(f"  总题目数: {total}, 本页: {len(questions)} 条, 已获取: {fetched + len(questions)}")

            for q in questions:
                writer.writerow(parse_question(q))
            fetched += len(questions)

            if MAX_FETCH and fetched >= MAX_FETCH:
                print(f"已达到最大数量 {MAX_FETCH}，停止获取！")
                break

            if not has_more:
                print("所有数据获取完成！")
                break

            skip += LIMIT
            page += 1
            time.sleep(1)

    print(f"结果已保存到: {OUTPUT}\n")

    # 与最新备份数据对比
    bak_file = find_latest_bak_file()
    if bak_file:
        print(f"对比备份文件: {os.path.basename(bak_file)}")
        compare_with_bak(OUTPUT, bak_file)
    else:
        print("未找到备份文件，跳过对比")


if __name__ == "__main__":
    main()