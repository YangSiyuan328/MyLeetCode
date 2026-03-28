package 剑指Offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

class Offer63_股票的最大利润 {

    public static void main(String[] args) {
        Offer63_股票的最大利润 o = new Offer63_股票的最大利润();
        System.out.println(o.maxProfit(new int[]{1, 5, 2, 4, 5, 56, 7, 5, 8}));//55
        System.out.println(o.maxProfit(new int[]{7, 1, 5, 3, 6, 4, 1, 2, 3, 5, 4}));//-1
    }


    // 动态规划
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        int res = 0, min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] <= min) {
                min = prices[i];
            }else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }

    // 暴力递归
    public int maxProfit1(int[] prices) {
        return process(prices, 0, 0);
    }

    private int process(int[] prices, int i, int curProfit) {
        if (i == prices.length) {
            return curProfit;
        }
        int curMaxProfit = curProfit;
        for (int j = i + 1; j < prices.length; j++) {
            curMaxProfit = Math.max(curMaxProfit, prices[j] - prices[i]);
        }
        int p = process(prices, i + 1, curProfit);
        return Math.max(p, curMaxProfit);
    }
}
