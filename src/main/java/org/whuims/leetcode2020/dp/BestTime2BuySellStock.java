package org.whuims.leetcode2020.dp;

public class BestTime2BuySellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(prices[i] - min, res);
        }

        return res;
    }
}