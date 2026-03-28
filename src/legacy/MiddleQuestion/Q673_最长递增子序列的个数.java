package MiddleQuestion;

public class Q673_最长递增子序列的个数 {

    /*
    參考300题
    [2,1]                   2
    [3,2,1]                 3
    [2,3,1,2,1]             2
    [1,2,4,3,5,4,7,2,5]     4
    [1,2,4,3,5,4,7,2]       3
     */
    public int findNumberOfLIS(int[] nums) {
        int l = nums.length;
        int[] afterNums = new int[l]; // 后面比他大的数字个数
        afterNums[l - 1] = 1;
        int[] dp = new int[l]; // 出现的最长长度的次数
        int length = 1;
        int count = 1;
        int max = 1;
        for (int i = l - 2; i >= 0; i--) {
            for (int j = i + 1; j < l; j++) {
                if (nums[j] > nums[i]) {
                    afterNums[i] = Math.max(afterNums[i], afterNums[j] + 1);
                }
                if (j == l - 1) {
                    afterNums[i] = Math.max(afterNums[i], 1);
                }
                if (afterNums[i] >= length) {
                    count = afterNums[i] == length ? count + dp[j] : 1;
                    length = afterNums[i];
                }
            }
            max = Math.max(max, length);
            dp[i] = count;
        }
        for (int i = 0; i < afterNums.length; i++) {
            if (afterNums[i] == max) {
                return dp[i];
            }
        }
        return -1;
    }

}
