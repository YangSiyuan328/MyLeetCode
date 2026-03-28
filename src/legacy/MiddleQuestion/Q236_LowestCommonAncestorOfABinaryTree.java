package MiddleQuestion;

public class Q236_LowestCommonAncestorOfABinaryTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // LCA 问题
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else return right;
    }

    public TreeNode lowestCommonAncestor2(TreeNode head, TreeNode p, TreeNode q) {
        if (p == q) return p;
        return getLowestCA(head, p, q).lowestCA;
    }

    private static class Info {
        boolean pInTree;
        boolean qInTree;
        TreeNode lowestCA;

        public Info(boolean pInTree, boolean qInTree, TreeNode lowestCA) {
            this.pInTree = pInTree;
            this.qInTree = qInTree;
            this.lowestCA = lowestCA;
        }
    }

    private static Info getLowestCA(TreeNode head, TreeNode p, TreeNode q) {
        if (head == null) return new Info(false, false, null);
        Info lTree = getLowestCA(head.left, p, q);
        Info rTree = getLowestCA(head.right, p, q);
        if (lTree.lowestCA != null || rTree.lowestCA != null) {
            return new Info(true, true, lTree.lowestCA == null ? rTree.lowestCA : lTree.lowestCA);
        }
        boolean pInTree = lTree.pInTree || rTree.pInTree;
        boolean qInTree = lTree.qInTree || rTree.qInTree;
        if (head == p) qInTree = true;
        if (head == q) pInTree = true;
        TreeNode lowestCA = pInTree && qInTree ? head : null;
        return new Info(pInTree, qInTree, lowestCA);
    }


}
