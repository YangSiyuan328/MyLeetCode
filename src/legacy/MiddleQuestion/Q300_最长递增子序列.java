package MiddleQuestion;

public class Q300_最长递增子序列 {

    public static int lengthOfLIS(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[l - 1] = 1;
        int max = 1;
        for (int i = l - 2; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                if (j == l - 1) {
                    dp[i] = Math.max(dp[i], 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
