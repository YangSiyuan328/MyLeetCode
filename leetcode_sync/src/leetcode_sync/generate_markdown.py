"""
题目 Markdown 文件生成模块

根据题目详情 CSV 数据，按题型分类生成 Markdown 草稿文件。
"""
import csv
import os
import re
import shutil

import html2text

from env_utils import DETAIL_CSV, GENERATED_DIR

# 题目类型到目录名的映射
TYPE_DIR_MAP = {
    "problems": os.path.join(GENERATED_DIR, "problems"),
    "LCP": os.path.join(GENERATED_DIR, "LCP"),
    "LCR": os.path.join(GENERATED_DIR, "LCR"),
    "LCS": os.path.join(GENERATED_DIR, "LCS"),
    "面试题": os.path.join(GENERATED_DIR, "interview"),
}

# html2text 转换器配置
H2T = html2text.HTML2Text()
H2T.ignore_links = False
H2T.body_width = 0


def parse_frontend_id(frontend_id: str) -> tuple[str, str | None, str | None]:
    """
    解析 frontendId，返回 (类型名, 主编号, 副编号)

    示例：
    - "1" → ("problems", "1", None)
    - "LCP 01" → ("LCP", "01", None)
    - "LCR 001" → ("LCR", "001", None)
    - "面试题 01.01" → ("面试题", "01", "01")
    """
    frontend_id = frontend_id.strip()

    if match := re.match(r"^LCP\s*(\d+)$", frontend_id, re.IGNORECASE):
        return "LCP", match.group(1), None

    if match := re.match(r"^LCR\s*(\d+)$", frontend_id, re.IGNORECASE):
        return "LCR", match.group(1), None

    if match := re.match(r"^LCS\s*(\d+)$", frontend_id, re.IGNORECASE):
        return "LCS", match.group(1), None

    if match := re.match(r"^面试题\s*(\d+)\.(\d+)$", frontend_id):
        return "面试题", match.group(1), match.group(2)

    if re.match(r"^\d+$", frontend_id):
        return "problems", frontend_id, None

    return "problems", frontend_id, None


def get_problem_type(frontend_id: str) -> tuple[str, str]:
    """
    根据题目的 frontendId 判断题目类型，返回 (类型名, 目录路径)

    类型判断规则：
    1. 纯数字 → problems (力扣标准题目)
    2. LCP XX → LCP
    3. LCR XXX → LCR
    4. LCS XX → LCS
    5. 面试题 XX → 面试题
    """
    problem_type, _, _ = parse_frontend_id(frontend_id)
    return problem_type, TYPE_DIR_MAP[problem_type]


def get_dir_name(frontend_id: str, slug: str) -> str:
    """
    根据题目类型生成目录名

    示例：
    - "1" → "lc0001_two_sum"
    - "LCP 01" → "LCP01_guess_numbers"
    - "LCR 001" → "LCR001_xxx"
    - "面试题 01.01" → "mst_01_01_xxx"
    """
    slug_name = slug.replace("-", "_")
    problem_type, num1, num2 = parse_frontend_id(frontend_id)

    if problem_type == "problems":
        return f"lc{num1.zfill(4)}_{slug_name}"
    elif problem_type == "LCP":
        return f"LCP{num1.zfill(2)}_{slug_name}"
    elif problem_type == "LCR":
        return f"LCR{num1.zfill(3)}_{slug_name}"
    elif problem_type == "LCS":
        return f"LCS{num1.zfill(2)}_{slug_name}"
    elif problem_type == "面试题":
        return f"mst_{num1.zfill(2)}_{num2.zfill(2)}_{slug_name}"

    return f"lc{frontend_id.zfill(4)}_{slug_name}"


def get_md_name(frontend_id: str, title: str) -> str:
    """
    根据题目类型生成 Markdown 文件名

    示例：
    - "1" → "lc0001_两数之和.md"
    - "LCP 01" → "LCP01_猜数字.md"
    - "面试题 01.01" → "mst_01_01_删除节点.md"
    """
    problem_type, num1, num2 = parse_frontend_id(frontend_id)

    if problem_type == "problems":
        return f"lc{num1.zfill(4)}_{title}.md"
    elif problem_type == "LCP":
        return f"LCP{num1.zfill(2)}_{title}.md"
    elif problem_type == "LCR":
        return f"LCR{num1.zfill(3)}_{title}.md"
    elif problem_type == "LCS":
        return f"LCS{num1.zfill(2)}_{title}.md"
    elif problem_type == "面试题":
        return f"mst_{num1.zfill(2)}_{num2.zfill(2)}_{title}.md"

    return f"lc{frontend_id.zfill(4)}_{title}.md"


def fix_markdown(text: str) -> str:
    # 去掉 4 空格缩进（html2text 把 <pre> 转成了代码块）
    text = re.sub(r"^    (.*)$", r"\1", text, flags=re.MULTILINE)
    # 去掉只含空白字符的行
    lines = [line for line in text.split("\n") if line.strip()]
    text = "\n".join(lines)
    # **加粗行** 和 ![](图片) 前补空行
    text = re.sub(r"\n(\*\*|!\[)", r"\n\n\1", text)
    return text.strip()


def strip_java_comment(code: str) -> str:
    """去掉 Java 代码开头的多行注释"""
    if not code:
        return code
    # 去掉开头的 /** ... */ 注释
    code = re.sub(r"^\s*/\*\*.*?\*/\s*", "", code, flags=re.DOTALL)
    return code.strip()


def generate_md(q: dict) -> str:
    difficulty = q["difficulty"]
    tags = q["topicTags"]
    url = q["url"]
    paid = "是" if q["isPaidOnly"] == "True" else "否"

    raw = q["translatedContent"] if q["translatedContent"] else q["content"]
    content = H2T.handle(raw)
    content = fix_markdown(content)

    java_code = strip_java_comment(q["javaCode"] or "")

    return f"""# {q['questionFrontendId']}. {q['translatedTitle'] or q['questionTitle']}

<table>
<tr><td><b>难度</b></td><td>{difficulty}</td></tr>
<tr><td><b>标签</b></td><td>{tags}</td></tr>
<tr><td><b>会员</b></td><td>{paid}</td></tr>
<tr><td><b>链接</b></td><td><a href="{url}">在线练习</a></td></tr>
</table>

## 题目描述

{content}

## 示例

```
{q['exampleTestcases']}
```

## 参考答案

```java
{java_code}
```

## 一刷思路

```java
{java_code}
```

## 二刷思路

```java
{java_code}
```
"""


def main():
    with open(DETAIL_CSV, "r", encoding="utf-8-sig") as f:
        reader = csv.DictReader(f)
        problems = list(reader)

    total = len(problems)
    print(f"开始处理，共 {total} 题")

    # 清空整个 generated/leetcode 目录
    if os.path.exists(GENERATED_DIR):
        shutil.rmtree(GENERATED_DIR)
    os.makedirs(GENERATED_DIR)

    # 创建各类型子目录
    for type_dir in TYPE_DIR_MAP.values():
        os.makedirs(type_dir, exist_ok=True)

    for i, q in enumerate(problems, 1):
        fid = q["questionFrontendId"]
        slug = q["titleSlug"]
        title = q.get("translatedTitle") or q["questionTitle"]

        # 根据题型获取存储目录
        problem_type, type_dir = get_problem_type(fid)
        dir_name = get_dir_name(fid, slug)
        problem_dir = os.path.join(type_dir, dir_name)
        md_name = get_md_name(fid, title)

        if i % 1000 == 0 or i == 1 or i == total:
            print(f"[{i}/{total}]")

        # 创建目录
        os.makedirs(problem_dir, exist_ok=True)

        # Markdown
        md_path = os.path.join(problem_dir, md_name)
        with open(md_path, "w", encoding="utf-8") as f:
            f.write(generate_md(q))

        # Solution.java
        if q["javaCode"]:
            java_path = os.path.join(problem_dir, "Solution.java")
            with open(java_path, "w", encoding="utf-8") as f:
                f.write(q["javaCode"])

    print(f"完成！共生成 {len(problems)} 题")
    print(f"输出目录: {GENERATED_DIR}")


if __name__ == "__main__":
    main()
