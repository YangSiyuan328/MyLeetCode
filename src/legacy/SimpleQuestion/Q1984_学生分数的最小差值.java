package SimpleQuestion;

import java.util.Arrays;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-05-11  15:37
 * @Description: TODO
 * @Version: 1.0
 */
public class Q1984_学生分数的最小差值 {

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        System.out.println("minimumDifference(nums,2) = " + minimumDifference(nums, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        if (k < 2) return 0;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int flag = k - 1;
        for (int i = flag; i < nums.length; i++) {
            ans = Math.min(ans, nums[i] - nums[i - flag]);
        }
        return ans;
    }

}
