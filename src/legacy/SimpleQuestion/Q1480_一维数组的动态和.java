package SimpleQuestion;

public class Q1480_一维数组的动态和 {

    public int[] runningSum(int[] nums) {
        if (nums.length == 1) return nums;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

}
