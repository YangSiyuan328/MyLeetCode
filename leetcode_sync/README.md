# leetcode_sync

LeetCode 题目数据同步工具，用于从 LeetCode CN 拉取题目数据并生成 Markdown 草稿。

## 功能模块

| 模块 | 功能 |
|------|------|
| `sync_problems_list.py` | 拉取题目列表，保存为 `题目列表.csv` |
| `parse_problem_detail.py` | 拉取题目详情（题目描述、示例、Java 参考代码等） |
| `generate_markdown.py` | 根据题目详情生成 Markdown 文件 |

## 目录结构

```
leetcode_sync/
├── .env                    # 环境变量配置
├── data/                   # 原始数据（CSV）
│   ├── 题目列表.csv
│   ├── 题目详情.csv
│   └── 题目列表_YYYYMMDD_bak.csv  # 备份文件
├── generated/leetcode/     # 生成的 Markdown 草稿
│   ├── problems/           # 标准题目 (lc0001_xxx)
│   ├── LCP/                # LCP 题目 (LCP01_xxx)
│   ├── LCR/                # LCR 题目 (LCR001_xxx)
│   ├── LCS/                # LCS 题目 (LCS01_xxx)
│   └── interview/          # 面试题 (mst_01_01_xxx)
└── src/leetcode_sync/      # Python 模块
```

## 使用方式

### 1. 配置环境变量

编辑 `.env` 文件，填入 LeetCode CN 的 Cookie：

```bash
LEETCODE_FREE_COOKIE=csrftoken=xxx; LEETCODE_SESSION=xxx
```

Cookie 可从浏览器 DevTools → Network → 任意请求 → Headers 中获取。

### 2. 拉取题目列表

```bash
uv run python src/leetcode_sync/sync_problems_list.py
```

输出：
- `data/题目列表.csv` - 所有题目列表
- 自动与最新备份对比，显示新增/删除/变化的题目

### 3. 拉取题目详情

```bash
uv run python src/leetcode_sync/parse_problem_detail.py
```

输出：
- `data/题目详情.csv` - 包含题目描述、示例、Java 参考代码等

### 4. 生成 Markdown

```bash
uv run python src/leetcode_sync/generate_markdown.py
```

输出：
- `generated/leetcode/` 下按题型分类的题目目录

每个题目目录包含：
- `lc0001_两数之和.md` - Markdown 文件
- `Solution.java` - Java 参考代码（如有）

## 环境变量说明

| 变量 | 说明 | 默认值 |
|------|------|--------|
| `LEETCODE_GRAPHQL_URL` | GraphQL API 地址 | - |
| `LEETCODE_FREE_COOKIE` | LeetCode CN Cookie | - |
| `LEETCODE_DETAIL_CONCURRENCY` | 详情拉取并发数 | 2 |
| `LEETCODE_LIMIT` | 每页请求条数 | 100 |
| `LEETCODE_MAX_FETCH` | 最大获取数量（测试用） | 0（不限制） |
| `LEETCODE_OUTPUT_DIR` | 输出目录 | data |