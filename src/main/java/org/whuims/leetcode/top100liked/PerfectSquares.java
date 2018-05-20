package org.whuims.leetcode.top100liked;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            int j = 1, min = Integer.MAX_VALUE;
            while (j * j <= i) {
                min = Math.min(min, dp[i - j * j] + 1);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
