package org.whuims.leetcode2020.dp;

public class StoneGame {

    public static void main(String[] args) {
        int[] piles = { 59, 48, 36, 70, 59, 93, 60, 98, 15, 32, 31, 13, 27, 14, 8, 17, 4, 76, 24, 47, 39, 81, 26, 6, 70,
                73, 8, 36, 71, 19, 66, 61, 86, 63, 97, 32, 15, 36, 68, 69, 32, 53, 83, 35, 100, 41, 44, 8, 28, 76, 39,
                90, 37, 35, 11, 99, 48, 49, 64, 74, 6, 54, 12, 99, 34, 47, 78, 36, 51, 26, 43, 83, 10, 68, 32, 48, 72,
                54, 64, 64, 44, 62, 77, 60, 100, 84, 15, 24, 95, 6, 6, 8, 24, 21, 84, 61, 75, 26, 63, 54 };
        System.out.println(new StoneGame().stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j]: 从到j Alex比bob多拿的石子数
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n - 1; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = len + i;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][n - 1] > 0;
    }
}