package org.whuims.leetcode2020.dp;

import java.util.Arrays;

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        System.out.println(i.isSubsequence("aaaaaa", "bbaaaa"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null) {
            return true;
        }
        if (t == null) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }

        int m = s.length();
        int n = t.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i <= m; i++) {
            char c1 = s.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = t.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];

                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}