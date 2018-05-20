package org.whuims.leetcode.top100liked;

public class BestTimeToBuySellStockWithCooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        int[] rest = new int[len];
        int[] buy = new int[len];
        int[] sell = new int[len];
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i < len; i++) {
            int price = prices[i];
            rest[i] = Math.max(rest[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - price);
            sell[i] = buy[i - 1] + price;
        }
        return Math.max(sell[len - 1], rest[len - 1]);
    }
}
