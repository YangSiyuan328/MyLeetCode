package 剑指Offer;

public class Offer54_二叉搜索树的第k大节点 {

    int n = 0;
    int res = 0;

    public int kthLargest(TreeNode head, int k) {
        n = k;
        helper(head);
        return res;
    }

    private void helper(TreeNode head) {
        if (head.right != null && n > 0) helper(head.right);
        n--;
        if (n == 0) {
            res = head.val;
            return;
        }
        if (head.left != null && n > 0) helper(head.left);
    }

}
