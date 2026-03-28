package 剑指OfferII;

import java.util.ArrayList;
import java.util.List;

public class OfferII084_含有重复元素集合的全排列 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        DFS(nums, 0, lists);
        return lists;
    }

    private void DFS(int[] nums, int i, List<List<Integer>> lists) {
        if (i == nums.length - 1) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            lists.add(list);
            return;
        }
        boolean[] visit = new boolean[21];
        for (int j = i; j < nums.length; j++) {
            if (!visit[nums[j] + 10]) {
                visit[nums[j] + 10] = true;
                swap(nums, i, j);
                DFS(nums, i + 1, lists);
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
