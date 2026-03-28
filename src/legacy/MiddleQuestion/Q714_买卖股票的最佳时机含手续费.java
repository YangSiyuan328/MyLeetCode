package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-04-09  04:46
 * @Description: TODO
 * @Version: 1.0
 */
public class Q714_买卖股票的最佳时机含手续费 {

    public int maxProfit(int[] prices, int fee) {
        int l = prices.length;
        if (l < 2) return 0;
        int bestBuy = -prices[0] - fee;
        int bestSell = 0;
        for (int price : prices) {
            bestBuy = Math.max(bestBuy, bestSell - price - fee);
            bestSell = Math.max(bestSell, bestBuy + price);
        }
        return bestSell;
    }

}
