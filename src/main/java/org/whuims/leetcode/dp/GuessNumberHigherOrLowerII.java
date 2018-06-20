package org.whuims.leetcode.dp;

public class GuessNumberHigherOrLowerII {

    public int getMoneyAmount(int n) {
        int[][] table = new int[n + 1][n + 1];
        return dp(table, 1, n);
    }

    int dp(int[][] t, int s, int e) {
        if (s >= e) {
            return 0;
        }
        if (t[s][e] != 0) {
            return t[s][e];
        }
        int res = Integer.MAX_VALUE;
        for (int i = s; i <= e; i++) {
            int tmp = i + Math.max(dp(t, s, i - 1), dp(t, i + 1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
}
