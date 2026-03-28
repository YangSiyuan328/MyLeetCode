package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-09  04:05
 * @Description: TODO
 * @Version: 1.0
 */
public class Q309_买卖股票的最佳时机含冷冻期 {

    public int maxProfit(int[] prices) {
        int l = prices.length;
        if (l < 2) return 0;
        int buy1 = Math.max(-prices[0], -prices[1]);
        int sell1 = Math.max(0, prices[1] - prices[0]);
        int sell2 = 0;
        for (int i = 2; i < l; i++) {
            int tmp = buy1;
            buy1 = Math.max(buy1, sell2 - prices[i]);
            sell2 = sell1;
            sell1 = Math.max(sell1, tmp + prices[i]);
        }
        return sell1;
    }

    /**
     * 空间压缩
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int l = prices.length;
        if (l < 2) return 0;
        int buy1 = Math.max(-prices[0], -prices[1]);
        int sell1 = Math.max(0, prices[1] - prices[0]);
        int sell2 = 0;
        for (int i = 2; i < l; i++) {
            int tmp = sell1;
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy1 = Math.max(buy1, sell2 - prices[i]);
            sell2 = tmp;
        }
        return sell1;
    }

    public int maxProfit1(int[] prices) {
        int l = prices.length;
        if (l < 2) return 0;
        int[] buy = new int[l];
        int[] sell = new int[l];
        // buy[0] = -prices[0]
        // sell[0] = 0
        buy[1] = Math.max(-prices[0], -prices[1]);
        sell[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < l; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[l - 1];
    }
}
