# 1678. 设计 Goal 解析器

<table>
<tr><td><b>难度</b></td><td>Easy</td></tr>
<tr><td><b>标签</b></td><td>字符串</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/goal-parser-interpretation/description/">在线练习</a></td></tr>
</table>

## 题目描述

请你设计一个可以解释字符串 `command` 的 **Goal 解析器** 。`command` 由 `"G"`、`"()"` 和/或 `"(al)"` 按某种顺序组成。Goal 解析器会将 `"G"` 解释为字符串 `"G"`、`"()"` 解释为字符串 `"o"` ，`"(al)"` 解释为字符串 `"al"` 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
给你字符串 `command` ，返回 __**Goal _****_ 解析器 **对 __`command` 的解释结果。

**示例 1：**

**输入：** command = "G()(al)"

**输出：** "Goal"

**解释：** Goal 解析器解释命令的步骤如下所示：
G -> G
() -> o
(al) -> al
最后连接得到的结果是 "Goal"

**示例 2：**

**输入：** command = "G()()()()(al)"

**输出：** "Gooooal"

**示例 3：**

**输入：** command = "(al)G(al)()()G"

**输出：** "alGalooG"

**提示：**
  * `1 <= command.length <= 100`
  * `command` 由 `"G"`、`"()"` 和/或 `"(al)"` 按某种顺序组成

## 示例

```
"G()(al)"
"G()()()()(al)"
"(al)G(al)()()G"
```

## 参考答案

```java
class Solution {
    public String interpret(String command) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public String interpret(String command) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public String interpret(String command) {
        
    }
}
```
