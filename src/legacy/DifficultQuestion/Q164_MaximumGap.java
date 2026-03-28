package DifficultQuestion;

import MiddleQuestion.Q912_SortAnArray;

import java.util.Arrays;

public class Q164_MaximumGap {
    public static void main(String[] args) {
        Q164_MaximumGap Q = new Q164_MaximumGap();
        System.out.println(Q.maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(Q.maximumGap(new int[]{10}));
        System.out.println(Q.maximumGap(new int[]{5, 2, 3, 1}));
        System.out.println(Q.maximumGap(new int[]{5, 1, 1, 2, 0, 0}));
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            res = Math.max(res, nums[i + 1] - nums[i]);
        }
        return res;
    }

}
