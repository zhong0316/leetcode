package org.whuims.leetcode2020.dp;

/**
 * 0-1背包
 */
public class ZeroOneKnapSack {

    public static void main(String[] args) {
        int[] v = { 12, 10, 20, 15 };
        int[] w = { 2, 1, 3, 2 };
        int c = 5;
        ZeroOneKnapSack z = new ZeroOneKnapSack();
        System.out.println(z.knapSackOneD(v, w, c));
    }

    /**
     * 
     * @param v
     * @param w
     * @param c
     * @return
     */
    public int knapSack(int[] v, int[] w, int c) {
        // 二维空间版本
        int n = v.length;
        // dp[i][j]: 前i个物品在容量为j的时候获取的最大价值
        int[][] dp = new int[n + 1][c + 1];
        // 初始化条件
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= w[i - 1]; j--) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        return dp[n][c];
    }

    public int knapSackOneD(int[] v, int[] w, int c) {
        // 一维空间版本
        int n = v.length;
        // dp[i]: 在容量为i时获取的最大价值
        int[] dp = new int[c + 1];
        dp[0] = 0;
        for (int k = 1; k <= n; k++) {
            for (int j = c; j >= w[k - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[k - 1]] + v[k - 1]);
            }
        }

        return dp[c];
    }
}