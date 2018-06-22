package org.whuims.leetcode.dp;

public class DominoAndTrominoTiling {

    public int numTilings(int N) {
        if (N <= 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        double M = 1e9 + 7;
        double[] dp = new double[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; ++i) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % M;
        }
        return (int) dp[N];
    }
}
