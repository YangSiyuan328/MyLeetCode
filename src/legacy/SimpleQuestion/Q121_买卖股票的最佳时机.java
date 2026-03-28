package SimpleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: SimpleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-21  21:13
 * @Description: TODO
 * @Version: 1.0
 */
public class Q121_买卖股票的最佳时机 {

    public static void main(String[] args) {
        Q121_买卖股票的最佳时机 Q = new Q121_买卖股票的最佳时机();
        int[] price = {7, 1, 5, 3, 6, 4};
        System.out.println("Q.maxProfit(price) = " + Q.maxProfit(price));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }

    public int maxProfit1(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }

    /**
     * 最优解
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        // 较低的价格买入
        int curMin = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            // 维护当前最小的买入价格
            curMin = Math.min(curMin, prices[i]);
            // 维护盈利最大值
            res = Math.max(res, prices[i] - curMin);
        }
        return res;
    }


    /**
     * 最优解
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 1.默认买入最低价为 prices[0]
        int min = prices[0];
        // 2.默认盈利最大值为 0
        int ans = 0;
        for (int price : prices) {
            // 3.维护当前最小数（买入最低价）
            min = Math.min(min, price);
            // 4.盈利最大值为 max(之前盈利最大值，当前盈利额)
            ans = Math.max(ans, price - min);
        }
        return ans;
    }



}
