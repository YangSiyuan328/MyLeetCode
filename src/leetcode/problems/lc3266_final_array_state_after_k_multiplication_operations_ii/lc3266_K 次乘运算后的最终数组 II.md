# 3266. K 次乘运算后的最终数组 II

<table>
<tr><td><b>难度</b></td><td>Hard</td></tr>
<tr><td><b>标签</b></td><td>数组;模拟;堆（优先队列）</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/final-array-state-after-k-multiplication-operations-ii/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个整数数组 `nums` ，一个整数 `k`  和一个整数 `multiplier` 。
你需要对 `nums` 执行 `k` 次操作，每次操作中：
  * 找到 `nums` 中的 **最小**  值 `x` ，如果存在多个最小值，选择最 **前面**  的一个。
  * 将 `x` 替换为 `x * multiplier` 。
`k` 次操作以后，你需要将 `nums` 中每一个数值对 `109 + 7` 取余。
请你返回执行完 `k` 次乘运算以及取余运算之后，最终的 `nums` 数组。

**示例 1：**

**输入：** nums = [2,1,3,5,6], k = 5, multiplier = 2

**输出：**[8,4,6,5,6]

**解释：**
操作 | 结果  
---|---  
1 次操作后 | [2, 2, 3, 5, 6]  
2 次操作后 | [4, 2, 3, 5, 6]  
3 次操作后 | [4, 4, 3, 5, 6]  
4 次操作后 | [4, 4, 6, 5, 6]  
5 次操作后 | [8, 4, 6, 5, 6]  
取余操作后 | [8, 4, 6, 5, 6]  

**示例 2：**

**输入：** nums = [100000,2000], k = 2, multiplier = 1000000

**输出：**[999999307,999999993]

**解释：**
操作 | 结果  
---|---  
1 次操作后 | [100000, 2000000000]  
2 次操作后 | [100000000000, 2000000000]  
取余操作后 | [999999307, 999999993]  

**提示：**
  * `1 <= nums.length <= 104`
  * `1 <= nums[i] <= 109`
  * `1 <= k <= 109`
  * `1 <= multiplier <= 106`

## 示例

```
[2,1,3,5,6]
5
2
[100000,2000]
2
1000000
```

## 参考答案

```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        
    }
}
```
