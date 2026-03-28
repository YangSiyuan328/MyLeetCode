package 剑指Offer;

import java.util.ArrayList;

public class Offer28_对称的二叉树 {

    public boolean isSymmetric(TreeNode head) {
        if (head == null) return true;
        return process(head.right, head.left);
    }

    /**
     *
     * @param left 左孩子
     * @param right 右孩子
     * @return 当前子树节点是否相同 && 向外延伸是否对称 && 向内延伸是否对称
     */
    private boolean process(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && process(left.left, right.right) && process(left.right, right.left);
    }
}
