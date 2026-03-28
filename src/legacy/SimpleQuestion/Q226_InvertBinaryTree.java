package SimpleQuestion;

public class Q226_InvertBinaryTree {
    TreeNode help;

    public TreeNode invertTree(TreeNode head) {
        if (head == null) return head;
        invertTree(head.left);
        invertTree(head.right);
        help = head.left;
        head.left = head.right;
        head.right = help;
        return head;
    }
}
