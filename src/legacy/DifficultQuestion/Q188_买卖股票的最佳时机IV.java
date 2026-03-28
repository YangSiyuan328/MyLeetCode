package DifficultQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: DifficultQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-09  02:18
 * @Description: TODO
 * @Version: 1.0
 */
public class Q188_买卖股票的最佳时机IV {

    public static void main(String[] args) {
        Q188_买卖股票的最佳时机IV Q = new Q188_买卖股票的最佳时机IV();
        System.out.println(Q.maxProfit(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }


    /**
     * 最优解
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) return 0;
        int l = prices.length;
        int[][] dp = new int[l][k + 1];
        for (int j = 1; j <= k; j++) {
            int best = -prices[0];
            for (int i = 1; i < l; i++) {
                best = Math.max(best, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(dp[i - 1][j], best + prices[i]);
            }
        }
        return dp[l - 1][k];
    }

    /**
     * 情况II
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) continue;
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) return 0;
        int l = prices.length;
        if (k >= l / 2) return maxProfit(prices);
        int[][] dp = new int[l][k + 1];
        int ans = 0;
        for (int j = 1; j <= k; j++) {
            int best = dp[0][j - 1] - prices[0];
            for (int i = 1; i < l; i++) {
                best = Math.max(best, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(dp[i - 1][j], best + prices[i]);
            }
        }
        return dp[l - 1][k];
    }

    public int maxProfit1(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) return 0;
        int l = prices.length;
        if (k >= l / 2) return maxProfit(prices);
        int[][] dp = new int[l][k + 1];
        // 默认初始值：dp[...][0] = 0
        // 默认初始值：dp[0][...] = 0
        for (int j = 1; j <= k; j++) {
            // dp[1][j] = ???;
            // dp[1][j] = 准备一些枚举;
            int p1 = dp[0][j];
//            int p2 = dp[1][j - 1] + prices[1] - prices[1];
//            int p3 = dp[0][j - 1] + prices[1] - prices[0];
//            dp[1][j] = Math.max(p1, Math.max(p2, p3));
//            可以优化为 best：
            int best = Math.max(dp[1][j - 1] - prices[1], dp[0][j - 1] - prices[0]);
            dp[1][j] = Math.max(p1, best + prices[1]);
            for (int i = 2; i < l; i++) {
                // dp[i][j]
                p1 = dp[i - 1][j];
                best = Math.max(best, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(p1, best + prices[i]);
            }
        }
        return dp[l - 1][k];
    }
}
