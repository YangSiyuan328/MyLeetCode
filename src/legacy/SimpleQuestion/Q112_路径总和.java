package SimpleQuestion;

public class Q112_路径总和 {

    public boolean hasPathSum(TreeNode head, int targetSum) {
        if (head == null) return false;
        if (head.right == null && head.left == null) return head.val == targetSum;
        return hasPathSum(head.left, targetSum - head.val)
                || hasPathSum(head.right, targetSum - head.val);
    }

}
