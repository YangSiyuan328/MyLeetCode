# 2723. 两个 Promise 对象相加

<table>
<tr><td><b>难度</b></td><td>Easy</td></tr>
<tr><td><b>标签</b></td><td></td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/add-two-promises/description/">在线练习</a></td></tr>
</table>

## 题目描述

给定两个 promise 对象 `promise1` 和 `promise2`，返回一个新的 promise。`promise1` 和 `promise2` 都会被解析为一个数字。返回的 Promise 应该解析为这两个数字的和。 

**示例 1：**

**输入：**
promise1 = new Promise(resolve => setTimeout(() => resolve(2), 20)), 
promise2 = new Promise(resolve => setTimeout(() => resolve(5), 60))

**输出：** 7

**解释：** 两个输入的 Promise 分别解析为值 2 和 5。返回的 Promise 应该解析为 2 + 5 = 7。返回的 Promise 解析的时间不作为判断条件。

**示例 2：**

**输入：**
promise1 = new Promise(resolve => setTimeout(() => resolve(10), 50)), 
promise2 = new Promise(resolve => setTimeout(() => resolve(-12), 30))

**输出：** -2

**解释：** 两个输入的 Promise 分别解析为值 10 和 -12。返回的 Promise 应该解析为 10 + -12 = -2。

**提示：**
  * `promise1 和 promise2` 都是被解析为一个数字的 promise 对象

## 示例

```
new Promise(resolve => setTimeout(() => resolve(2), 20))
new Promise(resolve => setTimeout(() => resolve(5), 60))
new Promise(resolve => setTimeout(() => resolve(10), 50))
new Promise(resolve => setTimeout(() => resolve(-12), 30))
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
