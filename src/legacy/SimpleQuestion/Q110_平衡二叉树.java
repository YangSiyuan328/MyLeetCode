package SimpleQuestion;

public class Q110_平衡二叉树 {

    public boolean isBalanced(TreeNode head) {
        return DFS(head).isBalance;
    }

    static class Info {
        boolean isBalance;
        int height;

        public Info(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }

    public Info DFS(TreeNode head) {
        if (head == null) return new Info(true, 0);
        Info left = DFS(head.left);
        Info right = DFS(head.right);
        boolean isBalance = left.isBalance && right.isBalance
                && Math.abs(left.height - right.height) <= 1;
        int height = Math.max(left.height, right.height) + 1;
        return new Info(isBalance, height);
    }

    public Info DFS1(TreeNode head) {
        if (head == null) return new Info(true, 0);
        Info left = DFS(head.left);
        Info right = DFS(head.right);
        if (!left.isBalance || !right.isBalance) {
            return new Info(false, 0);
        }
        if(Math.abs(left.height - right.height) > 1) {
            return new Info(false, 0);
        }
        int height = Math.max(left.height, right.height) + 1;
        return new Info(true, height);
    }

}
