package org.whuims.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        PalindromePartitioningII palindromePartitioningII = new PalindromePartitioningII();
        System.out.println(palindromePartitioningII.minCut("baccb"));
    }

    public int minCut(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1];
        Map<String, Boolean> cache = new HashMap<>();
        for (int i = 0; i < len; i++) {
            dp[i + 1] = i + 1;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(s, j, i, cache)) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[j] + 1);
                }
            }
        }
        return dp[len] - 1;
    }

    private boolean isPalindrome(String s, int i, int j, Map<String, Boolean> cache) {
        String key = i + "_" + j;
        if (i > j) {
            cache.put(key, false);
            return false;
        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                cache.put(key, false);
                return false;
            }
            i++;
            j--;
        }
        cache.put(key, true);
        return true;
    }
}
