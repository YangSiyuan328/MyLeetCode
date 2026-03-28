# 3163. 压缩字符串 III

<table>
<tr><td><b>难度</b></td><td>Medium</td></tr>
<tr><td><b>标签</b></td><td>字符串</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/string-compression-iii/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个字符串 `word`，请你使用以下算法进行压缩：
  * 从空字符串 `comp` 开始。当 `word` **不为空** 时，执行以下操作： 
* 移除 `word` 的最长单字符前缀，该前缀由单一字符 `c` 重复多次组成，且该前缀长度 **最多** 为 9 。
* 将前缀的长度和字符 `c` 追加到 `comp` 。
返回字符串 `comp` 。

**示例 1：**

**输入：** word = "abcde"

**输出：** "1a1b1c1d1e"

**解释：**
初始时，`comp = ""` 。进行 5 次操作，每次操作分别选择 `"a"`、`"b"`、`"c"`、`"d"` 和 `"e"` 作为前缀。
对每个前缀，将 `"1"` 和对应的字符追加到 `comp`。

**示例 2：**

**输入：** word = "aaaaaaaaaaaaaabb"

**输出：** "9a5a2b"

**解释：**
初始时，`comp = ""`。进行 3 次操作，每次操作分别选择 `"aaaaaaaaa"`、`"aaaaa"` 和 `"bb"` 作为前缀。
  * 对于前缀 `"aaaaaaaaa"`，将 `"9"` 和 `"a"` 追加到 `comp`。
  * 对于前缀 `"aaaaa"`，将 `"5"` 和 `"a"` 追加到 `comp`。
  * 对于前缀 `"bb"`，将 `"2"` 和 `"b"` 追加到 `comp`。

**提示：**
  * `1 <= word.length <= 2 * 105`
  * `word` 仅由小写英文字母组成。

## 示例

```
"abcde"
"aaaaaaaaaaaaaabb"
```

## 参考答案

```java
class Solution {
    public String compressedString(String word) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public String compressedString(String word) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public String compressedString(String word) {
        
    }
}
```
