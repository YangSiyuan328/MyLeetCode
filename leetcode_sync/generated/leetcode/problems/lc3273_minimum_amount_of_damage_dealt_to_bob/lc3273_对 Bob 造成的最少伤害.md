# 3273. 对 Bob 造成的最少伤害

<table>
<tr><td><b>难度</b></td><td>Hard</td></tr>
<tr><td><b>标签</b></td><td>贪心;数组;排序</td></tr>
<tr><td><b>会员</b></td><td>否</td></tr>
<tr><td><b>链接</b></td><td><a href="https://leetcode.cn/problems/minimum-amount-of-damage-dealt-to-bob/description/">在线练习</a></td></tr>
</table>

## 题目描述

给你一个整数 `power` 和两个整数数组 `damage` 和 `health` ，两个数组的长度都为 `n` 。
Bob 有 `n` 个敌人，如果第 `i` 个敌人还活着（也就是健康值 `health[i] > 0` 的时候），每秒钟会对 Bob 造成 `damage[i]` **点**  伤害。
每一秒中，在敌人对 Bob 造成伤害 **之后**  ，Bob 会选择 **一个**  还活着的敌人进行攻击，该敌人的健康值减少 `power` 。
请你返回 Bob 将 **所有**  `n` 个敌人都消灭之前，**最少**  会受到多少伤害。

**示例 1：**

**输入：** power = 4, damage = [1,2,3,4], health = [4,5,6,8]

**输出：** 39

**解释：**
  * 最开始 2 秒内都攻击敌人 3 ，然后敌人 3 会被消灭，这段时间内对 Bob 的总伤害是 `10 + 10 = 20` 点。
  * 接下来 2 秒内都攻击敌人 2 ，然后敌人 2 会被消灭，这段时间内对 Bob 的总伤害是 `6 + 6 = 12` 点。
  * 接下来 1 秒内都攻击敌人 0 ，然后敌人 0 会被消灭，这段时间内对 Bob 的总伤害是 `3` 点。
  * 接下来 2 秒内都攻击敌人 1 ，然后敌人 1 会被消灭，这段时间内对 Bob 的总伤害是 `2 + 2 = 4` 点。

**示例 2：**

**输入：** power = 1, damage = [1,1,1,1], health = [1,2,3,4]

**输出：** 20

**解释：**
  * 最开始 1 秒内都攻击敌人 0 ，然后敌人 0 会被消灭，这段时间对 Bob 的总伤害是 `4` 点。
  * 接下来 2 秒内都攻击敌人 1 ，然后敌人 1 会被消灭，这段时间对 Bob 的总伤害是 `3 + 3 = 6` 点。
  * 接下来 3 秒内都攻击敌人 2 ，然后敌人 2 会被消灭，这段时间对 Bob 的总伤害是 `2 + 2 + 2 = 6` 点。
  * 接下来 4 秒内都攻击敌人 3 ，然后敌人 3 会被消灭，这段时间对 Bob 的总伤害是 `1 + 1 + 1 + 1 = 4` 点。

**示例 3：**

**输入：** power = 8, damage = [40], health = [59]

**输出：** 320

**提示：**
  * `1 <= power <= 104`
  * `1 <= n == damage.length == health.length <= 105`
  * `1 <= damage[i], health[i] <= 104`

## 示例

```
4
[1,2,3,4]
[4,5,6,8]
1
[1,1,1,1]
[1,2,3,4]
8
[40]
[59]
```

## 参考答案

```java
class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        
    }
}
```

## 一刷思路

```java
class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        
    }
}
```

## 二刷思路

```java
class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        
    }
}
```
