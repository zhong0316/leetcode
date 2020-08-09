package org.whuims.leetcode2020.dp;

public class CoinChange2 {
    
    public static void main(String[] args) {
        CoinChange2 coinChange2 = new CoinChange2();
        System.out.println(coinChange2.waysToChange(10));
    }

    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] coins = new int[]{1, 5, 10, 25};
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[n] % mod;
    }
}