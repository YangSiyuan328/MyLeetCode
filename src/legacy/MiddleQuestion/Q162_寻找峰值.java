package MiddleQuestion;

public class Q162_寻找峰值 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = nums.length;
        int L = 1;
        int R = l - 2;
        int M = L + ((R - L) >> 1);
        while (L < R) {
            if (M == 0 || M == l - 1) return M;
            if (nums[M] >= nums[M - 1]) {
                L = M + 1;
            } else {
                R = M - 1;
            }
            M = L + ((R - L) >> 1);
        }
        return M;
    }

}
