# 220. 存在重复元素 III

<table>
<tr><td><b>难度</b></td><td>Hard</td></tr>
<tr><td><b>标签</b></td><td>数组;桶排序;有序集合;排序;滑动窗口</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/contains-duplicate-iii/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个整数数组 `nums` 和两个整数 `indexDiff` 和 `valueDiff` 。
找出满足下述条件的下标对 `(i, j)`：
  * `i != j`,
  * `abs(i - j) <= indexDiff`
  * `abs(nums[i] - nums[j]) <= valueDiff`
如果存在，返回 `true` _；_ 否则，返回 __`false` __ 。

**示例 1：**

**输入：** nums = [1,2,3,1], indexDiff = 3, valueDiff = 0

**输出：** true

**解释：** 可以找出 (i, j) = (0, 3) 。
满足下述 3 个条件：
i != j --> 0 != 3
abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0

**示例 2：**

**输入：** nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3

**输出：** false

**解释：** 尝试所有可能的下标对 (i, j) ，均无法满足这 3 个条件，因此返回 false 。

**提示：**
  * `2 <= nums.length <= 105`
  * `-109 <= nums[i] <= 109`
  * `1 <= indexDiff <= nums.length`
  * `0 <= valueDiff <= 109`

## 示例

```
[1,2,3,1]
3
0
[1,5,9,1,5,9]
2
3
```

## 参考答案

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        
    }
}
```
