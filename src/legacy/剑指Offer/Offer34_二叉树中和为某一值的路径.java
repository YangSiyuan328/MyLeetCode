package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

public class Offer34_二叉树中和为某一值的路径 {

    ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode head, int target) {
        dfs(head, target, new ArrayList<>());
        return lists;
    }

    private void dfs(TreeNode head, int target, ArrayList<Integer> list) {
        if (head == null) return;
        if (head.right == null && head.left == null) {
            if (target == head.val) {
                list.add(head.val);
                lists.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        list.add(head.val);
        dfs(head.right, target - head.val, list);
        dfs(head.left, target - head.val, list);
        list.remove(list.size() - 1);
    }
}

