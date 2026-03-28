package 剑指OfferII;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * 首先生成辅助数组，加速计算，再调用 arrayToTreeNode 构造 TreeNode
     * @param values 构造数组，数字下标从索引0开始
     */
    TreeNode(Integer[] values) {
        int l = values.length;
        Integer[] arr = new Integer[l + 1];
        System.arraycopy(values, 0, arr, 1, l);
        this.val = arr[1];
        this.left = arrayToTreeNode(arr, 2);
        this.right = arrayToTreeNode(arr, 3);
    }

    /**
     * @param arr 构造数组，数字下标从索引1开始
     * @param cur 当前位置
     */
    private TreeNode arrayToTreeNode(Integer[] arr, int cur) {
        if (cur >= arr.length || arr[cur] == null) return null;
        int value = arr[cur];
        TreeNode leftTreeNode = arrayToTreeNode(arr, cur << 1);
        TreeNode rightTreeNode = arrayToTreeNode(arr, cur << 1 | 1);
        return new TreeNode(value, leftTreeNode, rightTreeNode);
    }


    @Override
    public String toString() {
        System.out.print("先序遍历结果为：");
        preface(this);
        System.out.println();
        System.out.print("中序遍历结果为：");
        middleOrder(this);
        System.out.println();
        System.out.print("后序遍历结果为：");
        postSequence(this);
        return "";
    }

    /**
     * 先序遍历
     *
     * @param head 头结点或开始节点
     */
    private static void preface(TreeNode head) {
        if (head == null) return;
        System.out.print(" " + head.val);
        preface(head.left);
        preface(head.right);
    }

    /**
     * 中序遍历
     *
     * @param head 头结点或开始节点
     */
    private static void middleOrder(TreeNode head) {
        if (head == null) return;
        middleOrder(head.left);
        System.out.print(" " + head.val);
        middleOrder(head.right);
    }

    /**
     * 后序遍历
     *
     * @param head 头结点或开始节点
     */
    private static void postSequence(TreeNode head) {
        if (head == null) return;
        postSequence(head.left);
        postSequence(head.right);
        System.out.print(" " + head.val);
    }

}
