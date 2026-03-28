package MiddleQuestion;

import java.util.ArrayList;
import java.util.List;

public class Q47_PermutationsII {
    public static void main(String[] args) {
        Q47_PermutationsII Q = new Q47_PermutationsII();
        System.out.println(Q.permuteUnique(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, -1, new ArrayList<>(), res);
        return res;
    }

    public void permuteUnique(int[] nums, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == nums.length) {
            for (List<Integer> list : res) {
                if (list.equals(cur)) {
                    return;
                }
            }
            res.add(new ArrayList<>(cur));
            return;
        }
        if (index == -1) {
            cur.add(nums[0]);
            permuteUnique(nums, 1, cur, res);
            return;
        }
        for (int i = 0; i <= cur.size(); i++) {
            cur.add(i, nums[index]);
            permuteUnique(nums, index + 1, cur, res);
            cur.remove(i);
        }
    }
}
