package SimpleQuestion;

public class Q104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode head) {
        return getMaxDepth(head);
    }


    private static int getMaxDepth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int lDepth = getMaxDepth(head.left);
        int rDepth = getMaxDepth(head.right);
        return Math.max(getMaxDepth(head.left), getMaxDepth(head.right)) + 1;
    }

}
