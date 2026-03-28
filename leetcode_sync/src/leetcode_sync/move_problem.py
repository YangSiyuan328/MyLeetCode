"""
题目移动模块

将指定题号从 problems 目录移动到 temp 目录。
支持批量移动，自动补零匹配目录名。
"""
import os
import shutil
import sys

# 允许直接 python3 move_problem.py 运行
if __name__ == "__main__" and __package__ is None:
    sys.path.insert(0, os.path.join(os.path.dirname(__file__), ".."))
    __package__ = "leetcode_sync"

from .env_utils import GENERATED_DIR

PROBLEMS_DIR = os.path.join(GENERATED_DIR, "problems")
TEMP_DIR = os.path.join(GENERATED_DIR, "temp")


def move_problem(number: str) -> None:
    """
    将指定题号从 problems 目录移动到 temp 目录

    Args:
        number: 题号（支持 1、001、0001 等格式）
    """
    number = number.strip()
    padded = number.zfill(4)

    matched = [
        d for d in os.listdir(PROBLEMS_DIR)
        if os.path.isdir(os.path.join(PROBLEMS_DIR, d)) and d.startswith(f"lc{padded}_")
    ]

    if not matched:
        print(f"  未找到题号 {number} 对应的目录")
        return

    if len(matched) > 1:
        print(f"  匹配到多个目录: {matched}")
        return

    dir_name = matched[0]
    src = os.path.join(PROBLEMS_DIR, dir_name)
    dst = os.path.join(TEMP_DIR, dir_name)

    if os.path.exists(dst):
        print(f"  [{number}] {dir_name} - temp 目录下已存在，跳过")
        return

    os.makedirs(TEMP_DIR, exist_ok=True)
    shutil.move(src, dst)
    print(f"  [{number}] {dir_name} -> temp/{dir_name}")


def main() -> None:
    if len(sys.argv) < 2:
        print("用法: python3 move_problem.py <题号> [题号2 ...]")
        print("示例: python3 move_problem.py 1 42 200")
        sys.exit(1)

    print(f"源目录: {PROBLEMS_DIR}")
    print(f"目标目录: {TEMP_DIR}")
    print(f"共 {len(sys.argv) - 1} 题\n")

    for arg in sys.argv[1:]:
        move_problem(arg.strip())

    print("\n完成！")


if __name__ == "__main__":
    main()