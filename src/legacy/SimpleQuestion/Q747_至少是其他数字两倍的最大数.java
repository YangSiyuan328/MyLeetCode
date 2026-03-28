package SimpleQuestion;

public class Q747_至少是其他数字两倍的最大数 {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        int max2 = max;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max2 = max;
                max = nums[i];
                index = i;
            } else if (nums[i] >= max2) {
                max2 = nums[i];
            }
        }
        return max >= 2 * max2 ? index : -1;
    }
}
