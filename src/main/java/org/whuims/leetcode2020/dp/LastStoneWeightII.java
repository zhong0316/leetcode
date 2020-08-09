package org.whuims.leetcode2020.dp;

public class LastStoneWeightII {

    public static void main(String[] args) {
        LastStoneWeightII lastStoneWeightII = new LastStoneWeightII();
        int[] stones = new int[] { 35, 33, 30 };
        System.out.println(lastStoneWeightII.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        // 本质上是要把石头分成两份，两份质量差最小
        // 因此需要找到一堆石头使他们的质量之和接近sum / 2
        // 转换成背包问题，背包容量sum/2，尽可能多背石头
        int n = stones.length;
        // dp[i][j] 从i到j所拿的石头质量之和
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += stones[i];

        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (stones[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return sum - dp[n][sum / 2] - dp[n][sum / 2];
    }
}