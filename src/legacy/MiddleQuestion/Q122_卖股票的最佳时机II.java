package MiddleQuestion;

/**
 * @BelongsProject: MyLeetCode
 * @BelongsPackage: MiddleQuestion
 * @Author: 杨思远
 * @CreateTime: 2024-03-21  17:43
 * @Description: TODO
 * @Version: 1.0
 */
public class Q122_卖股票的最佳时机II {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0;
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    /**
     * 最优解
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) continue;
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }
}
