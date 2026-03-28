# LCP 04. 覆盖

<table>
<tr><td><b>难度</b></td><td>Hard</td></tr>
<tr><td><b>标签</b></td><td>位运算;图;数组;动态规划;位掩码</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/broken-board-dominoes/description/">在线练习</a></td></tr>
</table>

## 题目描述

你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为`1 * 2`的多米诺骨牌，你想把这些骨牌**不重叠** 地覆盖在**完好** 的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
输入：`n, m`代表棋盘的大小；`broken`是一个`b * 2`的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
输出：一个整数，代表最多能在棋盘上放的骨牌数。

**示例 1：**

**输入：** n = 2, m = 3, broken = [[1, 0], [1, 1]]

**输出：** 2

**解释：** 我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）

![](https://assets.leetcode.cn/aliyun-lc-upload/uploads/2019/09/09/domino_example_1.jpg)

**示例 2：**

**输入：** n = 3, m = 3, broken = []

**输出：** 4

**解释：** 下图是其中一种可行的摆放方式

![](https://assets.leetcode.cn/aliyun-lc-upload/uploads/2019/09/09/domino_example_2.jpg)

**限制：**
  1. `1 <= n <= 8`
  2. `1 <= m <= 8`
  3. `0 <= b <= n * m`

## 示例

```
2
3
[[1, 0], [1, 1]]
3
3
[]
```

## 参考答案

```java
class Solution {
    public int domino(int n, int m, int[][] broken) {

    }
}
```

## 一刷思路

```java
class Solution {
    public int domino(int n, int m, int[][] broken) {

    }
}
```

## 二刷思路

```java
class Solution {
    public int domino(int n, int m, int[][] broken) {

    }
}
```
