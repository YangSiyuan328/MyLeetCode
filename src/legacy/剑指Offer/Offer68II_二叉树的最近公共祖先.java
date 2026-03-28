package 剑指Offer;

public class Offer68II_二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) return null;
        if (head == p || head == q) return head;

        TreeNode left = lowestCommonAncestor(head.left, p, q);
        TreeNode right = lowestCommonAncestor(head.right, p, q);

        if (left != null && right != null) return head;
        if (left != null) return left;
        if (right != null) return right;

        return null;
    }


    public TreeNode lowestCommonAncestor1(TreeNode head, TreeNode p, TreeNode q) {
        if (p == q) return q;
        return process(head, p, q).ancestor;
    }

    private static Info process(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) return new Info(false, false, null);

        Info left = process(head.left, p, q);
        Info right = process(head.right, p, q);

        boolean pIn = left.pIn || right.pIn || head == p;
        boolean qIn = left.qIn || right.qIn || head == q;
        TreeNode ancestor = null;
        if (left.ancestor != null) {
            ancestor = left.ancestor;
        }
        if (right.ancestor != null) {
            ancestor = right.ancestor;
        }
        if (ancestor == null) {
            if (pIn && qIn) {
                ancestor = head;
            }
        }

        return new Info(pIn, qIn, ancestor);
    }

    private static class Info {
        boolean pIn;
        boolean qIn;
        TreeNode ancestor;

        public Info(boolean pIn, boolean qIn, TreeNode ancestor) {
            this.pIn = pIn;
            this.qIn = qIn;
            this.ancestor = ancestor;
        }
    }
}
