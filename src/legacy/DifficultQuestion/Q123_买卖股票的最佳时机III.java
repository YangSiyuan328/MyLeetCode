package DifficultQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: DifficultQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-22  00:28
 * @Description: TODO
 * @Version: 1.0
 */
public class Q123_买卖股票的最佳时机III {

    /**
     * 最优解
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int l = prices.length;
        int min = prices[0], min2 = prices[0];
        int ans = 0, ans2 = 0;
        for (int i = 0; i < l; i++) {
            // 第一次买股票股票花费
            min = Math.min(min, prices[i]);
            // 第一次卖股票股票盈利
            ans = Math.max(ans, prices[i] - min);
            // 第二次买股票股票花费
            min2 = Math.min(min2, prices[i] - ans);
            // 第一次卖股票股票盈利
            ans2 = Math.max(ans2, -min2 + prices[i]);
        }
        return ans2;
    }

    /**
     * 最优解
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int l = prices.length;
        int buy1 = -prices[0], buy2 = -prices[0];
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < l; i++) {
        }
        return sell2;
    }

    /**
     * 参考 Q188_买卖股票的最佳时机IV 中 k=2
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int l = prices.length;
        int[][] dp = new int[l][3];
        for (int j = 1; j <= 2; j++) {
            int best = -prices[0];
            for (int i = 1; i < l; i++) {
                best = Math.max(best, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(dp[i - 1][j], best + prices[i]);
            }
        }
        return dp[l - 1][2];
    }

}
