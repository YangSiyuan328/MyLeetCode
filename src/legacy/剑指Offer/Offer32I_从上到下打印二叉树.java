package 剑指Offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer32I_从上到下打印二叉树 {



    public int[] levelOrder1(TreeNode head) {
        if (head==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> help = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            help.add(temp);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        int[] ans = new int[help.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = help.poll().val;
        }
        return ans;
    }

}
