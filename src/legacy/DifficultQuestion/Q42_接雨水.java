package DifficultQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: DifficultQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-16  08:07
 * @Description: TODO
 * @Version: 1.0
 */
public class Q42_接雨水 {

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Q42_接雨水 Q = new Q42_接雨水();
        System.out.println("Q.trap(height) = " + Q.trap(height));
    }

    public int trap(int[] height) {
        int n = height.length;
        int[] leftDp = new int[n];
        int[] rightDp = new int[n];
        leftDp[0] = height[0];
        rightDp[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            leftDp[i] = Math.max(leftDp[i - 1], height[i]);
            rightDp[n - 1 - i] = Math.max(rightDp[n - i], height[n - 1 - i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftDp[i], rightDp[i]) - height[i];
        }
        return ans;
    }

}
