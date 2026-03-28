package MiddleQuestion;

public class Q396_旋转函数 {

    public int maxRotateFunction(int[] nums) {
        int maxSum = 0;
        int curSum = 0;
        int rotateSum = 0;
        int l = nums.length;
        for (int num : nums) {
            rotateSum += num;
        }
        for (int i = 0; i < l; i++) {
            curSum += i * nums[i];
        }
        maxSum = Math.max(maxSum, curSum);
        for (int i = 1; i < l; i++) {
            curSum += rotateSum;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

}
