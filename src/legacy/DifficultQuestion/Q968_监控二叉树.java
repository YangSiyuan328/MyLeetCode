package DifficultQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: DifficultQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-27  15:52
 * @Description: TODO
 * @Version: 1.0
 */
public class Q968_监控二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(new Integer[]{0, 0, null, null, 0, 0, null, null, 0, 0});
        Q968_监控二叉树 q = new Q968_监控二叉树();
        System.out.println("q.minCameraCover(treeNode) = " + q.minCameraCover(treeNode));
    }

    public int minCameraCover(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int case1 = minCameraCover(root, false);
        int case2 = minCameraCover(root, true);
        return Math.min(case1, case2);
    }

    /**
     * @param root
     * @param hasCamera 当前是否安装
     * @return
     */
    private int minCameraCover(TreeNode root, boolean hasCamera) {
        if (root == null) return 0;
        int leftNum = 0;
        int rightNum = 0;
        if (hasCamera) {
            leftNum = minCameraCover(root.left, false);
            rightNum = minCameraCover(root.right, false);
        } else {
            leftNum = minCameraCover(root.left, true);
            rightNum = minCameraCover(root.right, true);
        }
        return leftNum + rightNum + (hasCamera ? 1 : 0);
    }


}
