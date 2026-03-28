package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-28  12:52
 * @Description: TODO
 * @Version: 1.0
 */
public class Q746_使用最小花费爬楼梯 {
    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("minCostClimbingStairs(cost1) = " + minCostClimbingStairs2(cost1));
        System.out.println("minCostClimbingStairs(cost2) = " + minCostClimbingStairs2(cost2));
    }


    public static int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        if (l <= 1) return 0;
        int[] dp = new int[l];
        dp[l - 1] = cost[l - 1];
        dp[l - 2] = cost[l - 2];
        for (int i = l - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }

    // 减少空间
    public static int minCostClimbingStairs2(int[] cost) {
        int l = cost.length;
        if (l <= 1) return 0;
        if (l == 2) return Math.min(cost[0], cost[1]);
        int[] dp = new int[3];
        dp[2] = cost[l - 1];
        dp[1] = cost[l - 2];
        for (int i = l - 3; i >= 0; i--) {
            dp[0] = cost[i] + Math.min(dp[1], dp[2]);
            if (i == 0) break;
            dp[2] = dp[1];
            dp[1] = dp[0];
        }
        return Math.min(dp[0], dp[1]);
    }

//    // 超时
//    public static int minCostClimbingStairs(int[] cost) {
//        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
//    }
//
//    /**
//     *
//     * @param cost 费用数组
//     * @param index 当前所在的位置
//     * @return 总花费
//     */
//    public static int minCostClimbingStairs(int[] cost, int index) {
//        // 终止条件：达到最后一层
//        if (index >= cost.length) return 0;
//        return cost[index] + Math.min(minCostClimbingStairs(cost, index + 1), minCostClimbingStairs(cost, index + 2));
//    }




}
