package MiddleQuestion;

public class Q437_路径总和III {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        System.out.println(pathSum(head, 8));
    }

    public static int pathSum(TreeNode head, int targetSum) {
        if (head == null) return 0;
        return curPathSum(head, targetSum, false);
    }

    /**
     * 易错：一旦开始计算路径和向后传递的每一个 targetSum 都要减去 head.val
     * @param head 当前节点
     * @param targetSum 当前节点处开始需要得到的路径和为 targetSum
     * @param isStart 是否开始计算路径和
     * @return 路径和
     */
    public static int curPathSum(TreeNode head, int targetSum, boolean isStart) {
        if (head.left == null && head.right == null) return head.val == targetSum ? 1 : 0;
        int curPathSum = 0;
        if (head.val == targetSum) curPathSum++;
        int leftPathSum = 0;
        if (head.left != null) {
            leftPathSum = isStart ? 0 : curPathSum(head.left, targetSum, false); // 开始计算路径和后就不能向下传递原来的 targetSum 了
            curPathSum += curPathSum(head.left, targetSum - head.val, true);
        }
        int rightPathSum = 0;
        if (head.right != null) {
            rightPathSum = isStart ? 0 : curPathSum(head.right, targetSum, false);
            curPathSum += curPathSum(head.right, targetSum - head.val, true);
        }
        return curPathSum + leftPathSum + rightPathSum;
    }


}
