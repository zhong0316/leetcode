package org.whuims.leetcode.dp;

public class BestTimeToBuyAndSellStockIII {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII bestTimeToBuyAndSellStockIII = new BestTimeToBuyAndSellStockIII();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int res = bestTimeToBuyAndSellStockIII.maxProfit(prices);
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
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[3][len];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < len; i++) {
                min = Math.min(min, prices[i] - dp[k - 1][i - 1]);
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] - min);
            }
        }
        return dp[2][len - 1];
    }
}
