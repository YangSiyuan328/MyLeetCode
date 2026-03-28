package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-09  05:04
 * @Description: TODO
 * @Version: 1.0
 */
public class Q213_打家劫舍II {

    public static void main(String[] args) {
        Q213_打家劫舍II Q = new Q213_打家劫舍II();
        System.out.println("Q.rob(new int[]{4,1,2,7,5,3,1}) = " + Q.rob(new int[]{4, 1, 2, 7, 5, 3, 1}));
//        System.out.println("Q.rob(new int[]{4,1,2,7,5,3,1}) = " + Q.rob1(new int[]{4, 1, 2, 7, 5, 3, 1}));
    }

    public int rob(int[] nums) {
        int l = nums.length;
        if (l == 0) return 0;
        if (l == 1) return nums[0];
        if (l == 2) return Math.max(nums[0], nums[1]);
        int pre1 = nums[0];
        int ans1 = nums[0];
        for (int i = 2; i < l - 1; i++) {
            int tmp = Math.max(ans1, nums[i] + pre1);
            pre1 = ans1;
            ans1 = tmp;
        }
        int pre2 = 0;
        int ans2 = nums[1];
        for (int i = 2; i < l; i++) {
            int tmp = Math.max(ans2, nums[i] + pre2);
            pre2 = ans2;
            ans2 = tmp;
        }
        return Math.max(ans1, ans2);
    }

    public int rob1(int[] nums) {
        int l = nums.length;
        if (l == 0) return 0;
        if (l == 1) return nums[0];
        if (l == 2) return Math.max(nums[0], nums[1]);

        // dp[0] 代表第一个元素选，此时在 0~n-2 做打家劫舍1
        int[] dp1 = new int[nums.length];
        dp1[0] = nums[0];
        dp1[1] = nums[0];
        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        // dp[1] 代表第二个元素选，此时在 0~n-1 做打家劫舍1
        int[] dp2 = new int[nums.length];
        dp2[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }
}
