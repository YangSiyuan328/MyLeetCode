package 剑指Offer;

public class Offer55I_二叉树的深度 {

    public int maxDepth(TreeNode head) {
        if (head == null) return 0;
        return Math.max(maxDepth(head.left), maxDepth(head.right)) + 1;
    }
}
