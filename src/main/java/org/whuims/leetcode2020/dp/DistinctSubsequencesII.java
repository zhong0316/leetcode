package org.whuims.leetcode2020.dp;

import java.util.Arrays;

public class DistinctSubsequencesII {

    public static void main(String[] args) {
        DistinctSubsequencesII d = new DistinctSubsequencesII();
        System.out.println(d.distinctSubseqII("abc"));
    }

    public int distinctSubseqII(String S) {
        if (S.length() <= 1) {
            return S.length();
        }
        int mod = 1000000007;
        int n = S.length();
        int[] dp = new int[n + 1];
        // 字符在dp中最后一次出现的index
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, Integer.MIN_VALUE);
        // "", "a"
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int x = S.charAt(i) - 'a';
            dp[i + 1] = dp[i] * 2 % mod;
            if (lastSeen[x] >= 0) {
                dp[i + 1] -= dp[lastSeen[x]];
            }
            lastSeen[x] = i;
            dp[i + 1] %= mod;
        }
        if (dp[n] < 0) {
            dp[n] += mod;
        }

        return --dp[n];
    }
}