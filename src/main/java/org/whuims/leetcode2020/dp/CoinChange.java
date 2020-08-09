package org.whuims.leetcode2020.dp;

import java.util.Arrays;

public class CoinChange {
    
    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = new int[]{2,5,10,1};
        int amount = 27;
        System.out.println(coinChange.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int remain = amount;
        for (int i = 0; i < coins.length; i++) {
            remain = remain % coins[i];
            if (remain == 0) {
                break;
            }
        }
        
        if (remain != 0) {
            return -1;
        }
        // dp[i]:组成i所需最少硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1 );
            }
        }
        
        return dp[amount];
    }
}