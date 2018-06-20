package org.whuims.leetcode.dp;

import java.util.Arrays;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], N);
        }
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = N - 1, l = 0, r = 0, t = 0, d = 0; j < N; k--, j++) {
                dp[i][j] = Math.min(dp[i][j], l = (dp[i][j] == 0 ? 0 : l + 1));
                dp[i][k] = Math.min(dp[i][k], r = (dp[i][k] == 0 ? 0 : r + 1));
                dp[j][i] = Math.min(dp[j][i], t = (dp[j][i] == 0 ? 0 : t + 1));
                dp[k][i] = Math.min(dp[k][i], d = (dp[k][i] == 0 ? 0 : d + 1));
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
