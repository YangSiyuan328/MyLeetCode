package MiddleQuestion;

import java.util.*;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-18  21:57
 * @Description: TODO
 * @Version: 1.0
 */
public class Q491_非递减子序列 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.println("findSubsequences(nums) = " + findSubsequences(nums));
    }


    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        findSubsequences(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void findSubsequences(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        if (start >= nums.length) {
            return;
        }
        Set<Integer> set = new TreeSet<>(); // 记录本层元素是否使用
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            findSubsequences(nums, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
