package 剑指Offer;

public class Offer68I_二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) return null;

        if (p.val < head.val && q.val < head.val) return lowestCommonAncestor(head.left, p, q);
        if (p.val > head.val && q.val > head.val) return lowestCommonAncestor(head.right, p, q);

        return head;
    }

}
