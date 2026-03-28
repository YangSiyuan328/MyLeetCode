package 剑指Offer;

public class Offer55II_平衡二叉树 {

    public boolean isBalanced(TreeNode head) {
        return process(head).isBalanced;
    }

    private Info process(TreeNode head) {
        if (head == null) return new Info(0, true);
        Info L = process(head.left);
        Info R = process(head.right);
        int height = Math.max(L.height, R.height) + 1;
        boolean isBalanced = L.isBalanced && R.isBalanced && Math.abs(L.height - R.height) <= 1;
        return new Info(height, isBalanced);
    }

    private static class Info {
        int height;
        boolean isBalanced;

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

}
