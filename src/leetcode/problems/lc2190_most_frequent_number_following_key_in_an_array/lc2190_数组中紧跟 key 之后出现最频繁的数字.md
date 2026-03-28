# 2190. 数组中紧跟 key 之后出现最频繁的数字

<table>
<tr><td><b>难度</b></td><td>Easy</td></tr>
<tr><td><b>标签</b></td><td>数组;哈希表;计数</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/most-frequent-number-following-key-in-an-array/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个下标从 **0**  开始的整数数组 `nums` ，同时给你一个整数 `key` ，它在 `nums` 出现过。

**统计  **在 `nums` 数组中紧跟着 `key` 后面出现的不同整数 `target` 的出现次数。换言之，`target` 的出现次数为满足以下条件的 `i` 的数目：
  * `0 <= i <= n - 2`
  * `nums[i] == key` 且
  * `nums[i + 1] == target` 。
请你返回出现 **最多**  次数的 _ _`target` 。测试数据保证出现次数最多的 `target` 是唯一的。

**示例 1：**

**输入：** nums = [1,100,200,1,100], key = 1

**输出：** 100

**解释：** 对于 target = 100 ，在下标 1 和 4 处出现过 2 次，且都紧跟着 key 。
没有其他整数在 key 后面紧跟着出现，所以我们返回 100 。

**示例 2：**

**输入：** nums = [2,2,2,2,3], key = 2

**输出：** 2

**解释：** 对于 target = 2 ，在下标 1 ，2 和 3 处出现过 3 次，且都紧跟着 key 。
对于 target = 3 ，在下标 4 出出现过 1 次，且紧跟着 key 。
target = 2 是紧跟着 key 之后出现次数最多的数字，所以我们返回 2 。

**提示：**
  * `2 <= nums.length <= 1000`
  * `1 <= nums[i] <= 1000`
  * 测试数据保证答案是唯一的。

## 示例

```
[1,100,200,1,100]
1
[2,2,2,2,3]
2
```

## 参考答案

```java
class Solution {
    public int mostFrequent(int[] nums, int key) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public int mostFrequent(int[] nums, int key) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public int mostFrequent(int[] nums, int key) {
        
    }
}
```
