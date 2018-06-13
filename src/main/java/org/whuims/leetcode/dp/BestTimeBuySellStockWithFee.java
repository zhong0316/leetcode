package org.whuims.leetcode.dp;

public class BestTimeBuySellStockWithFee {

    public static void main(String[] args) {
        BestTimeBuySellStockWithFee bestTimeBuySellStockWithFee = new BestTimeBuySellStockWithFee();
        int[] prices = {1, 3, 7, 5, 10, 3};
        int res = bestTimeBuySellStockWithFee.maxProfit(prices, 3);
        System.out.println(res);
    }

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = prices[0] * -1;
        sell[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        return sell[prices.length - 1];
    }

}
