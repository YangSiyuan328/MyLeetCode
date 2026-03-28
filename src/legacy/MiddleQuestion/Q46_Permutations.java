package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    public static void main(String[] args) {
        Q46_Permutations Q = new Q46_Permutations();
        System.out.println(Q.permute(new int[]{1, 2, 3}));
//        System.out.println(Q.permute(new int[]{0, 1}));
//        System.out.println(Q.permute(new int[]{1}));
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(1);
//        System.out.println(arrayList);
//        arrayList.add(1, 8);
//        System.out.println(arrayList);
//        arrayList.remove(1);
//        System.out.println(arrayList);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }

    public void process(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length - 1) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int num : nums) {
                tmp.add(num);
            }
            ans.add(tmp);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(nums, i + 1, ans);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
