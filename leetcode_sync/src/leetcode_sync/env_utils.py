"""
环境变量和路径配置集中管理模块

所有 LeetCode 相关的配置项在此模块统一初始化，
其他模块通过导入使用，避免重复的 load_dotenv 调用。
"""
import os

from dotenv import load_dotenv

# 项目根目录
PROJECT_ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))

# 加载 .env 文件
load_dotenv(os.path.join(PROJECT_ROOT, ".env"))

# LeetCode API 配置
URL = os.environ["LEETCODE_GRAPHQL_URL"]
COOKIE = os.environ["LEETCODE_FREE_COOKIE"]
GRAPHQL_QUERY = os.environ["LEETCODE_GRAPHQL_QUERY"]

# 请求配置
LIMIT = int(os.environ["LEETCODE_LIMIT"])
MAX_FETCH = int(os.getenv("LEETCODE_MAX_FETCH", "0")) or None
CONCURRENCY = int(os.getenv("LEETCODE_DETAIL_CONCURRENCY", "2"))

# 目录配置
OUTPUT_DIR = os.path.join(PROJECT_ROOT, os.environ["LEETCODE_OUTPUT_DIR"])
DATA_DIR = os.path.join(PROJECT_ROOT, "data")
GENERATED_DIR = os.path.join(PROJECT_ROOT, "generated", "leetcode")
MY_LEETCODE_ROOT = os.path.dirname(PROJECT_ROOT)
PROBLEMS_DIR = os.path.join(GENERATED_DIR, "problems")
TARGET_DIR = os.path.join(MY_LEETCODE_ROOT, "src", "leetcode", "problems")

# 文件路径
LIST_CSV = os.path.join(OUTPUT_DIR, "题目列表.csv")
DETAIL_CSV = os.path.join(OUTPUT_DIR, "题目详情.csv")

# HTTP Headers
HEADERS = {
    "Content-Type": "application/json",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36",
    "Cookie": COOKIE,
}