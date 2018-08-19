package org.whuims.leetcode.dp;

public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV bestTimeToBuyAndSellStockIV = new BestTimeToBuyAndSellStockIV();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        int res = bestTimeToBuyAndSellStockIV.maxProfit(k, prices);
        System.out.println(res);
    }

    /**
     * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     * For k transactions, on i-th day,
     * if we don't trade then the profit is same as previous day dp[k, i-1];
     * and if we bought the share on j-th day where j=[0..i-1], then sell the share on i-th day then the profit is prices[i] - prices[j] + dp[k-1, j-1] .
     * Actually j can be i as well. When j is i, the one more extra item prices[i] - prices[j] + dp[k-1, j] = dp[k-1, i] looks like we just lose one chance of transaction.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        int[][] dp = new int[k + 1][len];
        for (int t = 1; t <= k; t++) {
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, prices[i] - dp[t - 1][i - 1]);
                dp[t][i] = Math.max(dp[t][i - 1], prices[i] - min);
            }
        }
        return dp[k][len - 1];
    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
