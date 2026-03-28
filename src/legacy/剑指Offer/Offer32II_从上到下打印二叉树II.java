package 剑指Offer;

import java.util.*;

public class Offer32II_从上到下打印二叉树II {

    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode head) {
        if (head == null) return res;
        dfs(0, head);
        return res;
    }

    private void dfs(int deep, TreeNode node) {
        if (node == null) return;
        if (res.size() == deep) {
            res.add(new ArrayList<>());
        }
        res.get(deep).add(node.val);
        dfs(deep + 1, node.left);
        dfs(deep + 1, node.right);
    }

    public List<List<Integer>> levelOrder1(TreeNode head) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (head == null) return lists;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        int curLevel = 1;
        int curLevelNodes = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (cur.left != null) {
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
            if (curNodeLevel == curLevel) {
                list.add(cur.val);
            } else {
                lists.add(list);
                curLevel++;
                list = new ArrayList<>();
                list.add(cur.val);
            }
        }
        if (list.size() != 0) lists.add(list);
        return lists;
    }

}
