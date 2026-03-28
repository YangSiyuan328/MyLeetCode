package 剑指OfferII;

/*
r左边的元素均已经考虑了所有的组合, 所以我们只要考虑含r的组合,
显然含r的组合数刚好是子数组的长度
举个例子 [...5,6,3,4,8,...] 假设r遍历到了数值8的位置, l经过摘除后移到了数值5处,
此时所有的组合情况是:
[56348]
[6348]
[348]
[48]
[8]
即5种
 */
public class OfferII009_乘积小于K的子数组 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) return 0;
        int l = 0;
        int product = 1; // 窗口内乘积
        int count = 0; // 统计满足情况的数组个数
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            count += r - l + 1; // 统计当前 r 位置情况下，窗口内所有的连续的子数组的个数
        }
        return count;
    }
}
