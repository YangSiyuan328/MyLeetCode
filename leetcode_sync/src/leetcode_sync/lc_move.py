"""
题目移动模块

将指定题号从 generated problems 目录复制到 src/leetcode/problems 目录。
支持批量复制，自动补零匹配目录名。
全局支持
"""
import os
import shutil
import sys

# 项目根目录（leetcode_sync/），与 env_utils 保持一致
_PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
_MY_LEETCODE_ROOT = os.path.dirname(_PROJECT_ROOT)

PROBLEMS_DIR = os.path.join(_PROJECT_ROOT, "generated", "leetcode", "problems")
TARGET_DIR = os.path.join(_MY_LEETCODE_ROOT, "src", "leetcode", "problems")


def move_problem(number: str) -> None:
    """
    将指定题号从 generated problems 目录复制到 src/leetcode/problems 目录

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
    dst = os.path.join(TARGET_DIR, dir_name)

    if os.path.exists(dst):
        print(f"  [{number}] {dir_name} - 目标目录已存在，跳过")
        return

    os.makedirs(TARGET_DIR, exist_ok=True)
    shutil.copytree(src, dst)
    print(f"  [{number}] {dir_name} -> src/leetcode/problems/{dir_name}")


def main() -> None:
    if len(sys.argv) < 2:
        print("用法: py-lc-move <题号> [题号2 ...]")
        print("示例: py-lc-move 1 42 200")
        sys.exit(1)

    print(f"源目录: {PROBLEMS_DIR}")
    print(f"目标目录: {TARGET_DIR}")
    print(f"共 {len(sys.argv) - 1} 题\n")

    for arg in sys.argv[1:]:
        move_problem(arg.strip())

    print("\n完成！")


if __name__ == "__main__":
    main()