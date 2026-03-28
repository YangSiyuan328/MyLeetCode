package MiddleQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q39_CombinationSum {


    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        process(candidates, target, target, 0, 0, new LinkedList<Integer>());
        return lists;
    }

    private void process(int[] candidates, int surplusTarget, int maxCount, int curCount, int i, LinkedList<Integer> list) {
        if (curCount > maxCount) return;
        if (surplusTarget == 0) {
            lists.add(new ArrayList<>(list));
        }
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] <= surplusTarget) {
                list.add(candidates[j]);
                process(candidates, surplusTarget - candidates[j], maxCount, curCount + 1, j, list);
                list.remove(curCount);
            }
        }
    }

}
