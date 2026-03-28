package SimpleQuestion;

public class Q111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode head) {
        return getMinDepth(head);
    }

    private int getMinDepth(TreeNode head) {
        if (head == null) return 0;
        int l = getMinDepth(head.left);
        int r = getMinDepth(head.right);
        return l == 0 || r == 0 ? (l == 0 ? r + 1 : l + 1) : Math.min(l, r) + 1;
    }
}
