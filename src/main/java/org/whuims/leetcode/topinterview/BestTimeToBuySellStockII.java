package org.whuims.leetcode.topinterview;

public class BestTimeToBuySellStockII {

    int maxProfit = 0;

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        greedy(prices, 0, prices.length);
        return maxProfit;
    }

    private void greedy(int[] prices, int start, int len) {
        if (start >= len) {
            return;
        }
        while (start < len - 1 && prices[start] >= prices[start + 1]) {
            start++;
        }
        int profit = -prices[start];
        while (start < len - 1 && prices[start] <= prices[start + 1]) {
            start++;
        }
        profit += prices[start];
        maxProfit += profit;
        greedy(prices, start + 1, len);
    }

}
