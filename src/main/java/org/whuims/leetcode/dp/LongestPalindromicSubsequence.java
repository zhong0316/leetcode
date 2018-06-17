package org.whuims.leetcode.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        int res = longestPalindromicSubsequence.longestPalindromeSubseq("abaababaab");
        System.out.println(res);
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] sc = s.toCharArray();
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, 1);
        }
        int max = 1;
        for (int dis = 2; dis <= n; dis++) {
            for (int i = 0; i <= n - dis; i++) {
                int j = i + dis - 1;
                if (sc[i] == sc[j] && dis == 2) {
                    dp[i][j] = 2;
                } else if (sc[i] == sc[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
