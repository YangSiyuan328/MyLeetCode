# MyLeetCode

一个用于算法练习与题解整理的轻量仓库。

仓库根目录本身不是 Python 项目；与 LeetCode 同步相关的 Python 工程单独维护在 `leetcode_sync/`。

## 仓库结构

```text
src/
├── leetcode/   # 新的 LeetCode 题目与索引
├── offer/      # 新的 剑指 Offer 题目与索引
├── contest/    # 新的竞赛题目与索引
├── common/     # 公共工具
└── legacy/     # 历史题解，保留原样

leetcode_sync/
├── src/        # 同步子项目源码
└── generated/  # 机器生成的 LeetCode 草稿内容
```

## 维护规则

- 新结构下如需写题目说明，请在对应题目目录内维护同路径 `README.md`。
- 单题 README 保持轻量，记录题目链接、来源、状态、简要题意与核心思路即可。
- `src/common/` 用于公共工具，目前不维护题目索引。
- `leetcode_sync/` 是独立同步子项目，机器生成内容固定输出到 `leetcode_sync/generated/`。
- 正式人工维护内容仍位于 `src/leetcode/problems/`，当前保持“先生成、人工检查、再手动迁移”的工作流。
- 如需验证抓取或整理逻辑，优先使用 notebook；确认稳定后再整理为 `leetcode_sync/src/` 下的正式代码。

## 历史说明

历史题解保留在 `src/legacy/` 下。
它们仅作为参考，不会回填到新的 README 维护流程中。
