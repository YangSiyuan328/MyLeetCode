package 剑指Offer;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Offer57_和为s的两个数字 {

    // 双指针
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int cur = nums[left] + nums[right];
            if (cur == target) {
                return new int[]{nums[left], nums[right]};
            } else if (cur > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    // set集合
    public int[] twoSum1(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(target - num)) {
                set.add(num);
            } else {
                return new int[]{num, target - num};
            }
        }
        return null;
    }

}
