package MiddleQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-29  23:51
 * @Description: TODO
 * @Version: 1.0
 */
public class Q416_分割等和子集 {
    public static void main(String[] args) {
        Q416_分割等和子集 q = new Q416_分割等和子集();
        System.out.println("q.canPartition(new int[]{1, 2, 5}) = " + q.canPartition(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = getSum(nums);
        if (sum % 2 == 1) return false;
        int target = sum >> 1;
        return process(nums, 0, 0, target);

    }

    private boolean process(int[] nums, int index, int sum, int aim) {
        if (index >= nums.length) return sum == aim;
        if (sum == aim) return true;
        return process(nums, index + 1, sum + nums[index], aim) | process(nums, index + 1, sum, aim);
    }


    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

}
