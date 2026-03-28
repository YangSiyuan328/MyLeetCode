# 3793. 查找高 tokens 使用量的用户

<table>
<tr><td><b>难度</b></td><td>Easy</td></tr>
<tr><td><b>标签</b></td><td></td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/find-users-with-high-token-usage/description/">在线练习</a></td></tr>
</table>

## 题目描述

表：`prompts`
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| user_id     | int     |
| prompt      | varchar |
| tokens      | int     |
+-------------+---------+
(user_id, prompt) 是这张表的主键（值互不相同）。
每一行表示一个用户提交给 AI 系统的提示词以及所消耗的 token 数量。
根据下列要求编写一个解决方案来分析 **AI 提示词的使用模式** ：
  * 对每一个用户，计算他们提交的 **提示词的总数** 。
  * 对每个用户，计算 **每个提示词所使用的平均 token 数** （舍入到 `2` 位小数）。
  * 仅包含 **至少提交了`3` 个提示词** 的用户。
  * 仅包含那些 **至少提交过一个提示词** 且该提示词的 `tokens` 数量 **超过** 自己平均 token 使用量的用户。
返回结果表按 **平均 token 数 降序**  排序，然后按 _ _`user_id` **升序**  排序。
结果格式如下所示。

**示例：**

**输入：**
prompts 表：
+---------+--------------------------+--------+
| user_id | prompt                   | tokens |
+---------+--------------------------+--------+
| 1       | Write a blog outline     | 120    |
| 1       | Generate SQL query       | 80     |
| 1       | Summarize an article     | 200    |
| 2       | Create resume bullet     | 60     |
| 2       | Improve LinkedIn bio     | 70     |
| 3       | Explain neural networks  | 300    |
| 3       | Generate interview Q&A   | 250    |
| 3       | Write cover letter       | 180    |
| 3       | Optimize Python code     | 220    |
+---------+--------------------------+--------+

**输出：**
+---------+---------------+------------+
| user_id | prompt_count  | avg_tokens |
+---------+---------------+------------+
| 3       | 4             | 237.5      |
| 1       | 3             | 133.33     |
+---------+---------------+------------+

**解释：**
  * **用户 1：**
* 总提示词数 = 3
* 平均 token 数 = (120 + 80 + 200) / 3 = 133.33
* 有一个提示词为 200 个 token，这超过了平均值
* 包含在结果中
  * **用户 2** : 
* 总提示词数 = 2（少于所需的最小值）
* 从结果中排除
  * **用户 3** : 
* 总提示词数 = 4
* 平均 token 数 = (300 + 250 + 180 + 220) / 4 = 237.5
* 有包含 300 和 250 个 token 的提示词，都大于平均数
* 包含在结果中
结果表按 avg_tokens 降序排序，然后按 user_id 升序排序。

## 示例

```
{"headers":{"prompts":["user_id","prompt","tokens"]},"rows":{"prompts":[[1,"Write a blog outline",120],[1,"Generate SQL query",80],[1,"Summarize an article",200],[2,"Create resume bullet",60],[2,"Improve LinkedIn bio",70],[3,"Explain neural networks",300],[3,"Generate interview Q&A",250],[3,"Write cover letter",180],[3,"Optimize Python code",220]]}}
```

## 参考答案

```java

```

## 一刷思路

```java

```

## 二刷思路

```java

```
