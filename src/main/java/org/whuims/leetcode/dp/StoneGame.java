package org.whuims.leetcode.dp;

public class StoneGame {

    public static void main(String[] args) {
        StoneGame stoneGame = new StoneGame();
        int[] piles = {1,3,1,2};
        System.out.println(stoneGame.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        // dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1];
        // dp[i][j]代表piles[i]~piles[j]区间内第一个先走的人比另一个多的积分数
        for (int i = 0; i < n; i++) dp[i][i] = piles[i];
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                dp[i][i + d] = Math.max(piles[i] - dp[i + 1][i + d], piles[i + d] - dp[i][i + d - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
