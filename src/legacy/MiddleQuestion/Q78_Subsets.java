package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {
    public static void main(String[] args) {
        Q78_Subsets Q = new Q78_Subsets();
        List<List<Integer>> subsets = Q.subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        process(nums, 0, 0, new ArrayList<Integer>());
        return lists;
    }

    private void process(int[] nums, int i, int listLength, ArrayList<Integer> list) {
        if (i == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        System.out.println(i);
        process(nums, i + 1, listLength, list);
        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            process(nums, j + 1, listLength + 1, list);
            list.remove(listLength);
        }
    }
}
