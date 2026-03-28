package MiddleQuestion;

import java.util.LinkedList;

public class Q713_乘积小于K的子数组 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(new Q713_乘积小于K的子数组().numSubarrayProductLessThanK(nums, 1));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || k <= 1) return 0;
        int l = nums.length;
        int p = 0;
        int prod = 1; //存储nums[l]~nums[r]的累积
        int res = 0;
        for (int r = 0; r < l; r++) {
            prod *= nums[r];
            while (prod >= k) {
                prod /= nums[p++];
            }
            res += r - p + 1;
        }
        return res;
    }
}
