package org.whuims.leetcode2020.dp;

import java.util.Arrays;

/**
 * A chess knight can move as indicated in the chess diagram below:
 * 
 * .
 * 
 * 
 * 
 * This time, we place our chess knight on any numbered key of a phone pad
 * (indicated above), and the knight makes N-1 hops. Each hop must be from one
 * key to another numbered key.
 * 
 * Each time it lands on a key (including the initial placement of the knight),
 * it presses the number of that key, pressing N digits total.
 * 
 * How many distinct numbers can you dial in this manner?
 * 
 * Since the answer may be large, output the answer modulo 10^9 + 7.
 * 
 * 
 */
public class KnightDialer {

    public static void main(String[] args) {
        KnightDialer k = new KnightDialer();
        System.out.println(k.knightDialer(2));
    }

    public int knightDialer(int N) {
        int mod = 1000000007;
        int[][] moves = { { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 0, 3, 9 }, {}, { 0, 1, 7 }, { 2, 6 }, { 1, 3 },
                { 2, 4 } };
        int[][] dp = new int[N + 1][10];
        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k < moves[j].length; k++) {
                    dp[i][j] += dp[i - 1][moves[j][k]];
                    dp[i][j] %= mod;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += dp[N][i];
        }
        ans %= mod;
        return (int) ans;
    }
}