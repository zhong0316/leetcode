package org.whuims.leetcode2020.dp;

public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares p = new PerfectSquares();
        System.out.println(p.numSquares(12));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}