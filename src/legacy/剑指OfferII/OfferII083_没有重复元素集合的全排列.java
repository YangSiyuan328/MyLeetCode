package 剑指OfferII;

import java.util.ArrayList;
import java.util.List;

public class OfferII083_没有重复元素集合的全排列 {

    public static void main(String[] args) {
        OfferII083_没有重复元素集合的全排列 o = new OfferII083_没有重复元素集合的全排列();
        System.out.println(o.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
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
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            DFS(nums, i + 1, lists);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
