package MiddleQuestion;

public class Q55_JumpGame {

    public static void main(String[] args) {
        Q55_JumpGame Q = new Q55_JumpGame();
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};
        int[] nums3 = {0, 1};
        System.out.println("Q.canJump(nums) = " + Q.canJump(nums));
        System.out.println("Q.canJump(nums2) = " + Q.canJump(nums2));
        System.out.println("Q.canJump(nums3) = " + Q.canJump(nums3));
    }

    public boolean canJump(int[] nums) {
        int l = nums.length;
        if (l == 0) return false;
        // 可以走的步数
        int step = nums[0];
        for (int i = 1; i < l; i++) {
            // 可以走0
            if (step == 0) return false;
            step = Math.max(--step, nums[i]);
            if (step >= l - i) return true;
        }
        return true;
    }

}
