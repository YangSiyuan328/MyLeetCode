package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-21  10:24
 * @Description: TODO
 * @Version: 1.0
 */
public class Q45_跳跃游戏II {

    public static void main(String[] args) {
        Q45_跳跃游戏II Q = new Q45_跳跃游戏II();
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1};
        int[] nums4 = {1, 2};
        int[] nums5 = {1, 2, 3};
        System.out.println("Q.canJump(nums) = " + Q.jump(nums));
        System.out.println("Q.canJump(nums2) = " + Q.jump(nums2));
        System.out.println("Q.canJump(nums3) = " + Q.jump(nums3));
        System.out.println("Q.canJump(nums5) = " + Q.jump(nums5));
    }

    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i <= end && end < nums.length - 1; i++) {
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) { //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


}
