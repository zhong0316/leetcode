package org.whuims.leetcode2020.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak s = new WordBreak();
        List<String> list = Arrays.asList("leet", "code");
        System.out.println(s.wordBreak("leetcode", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (set.contains(temp)) {
                    dp[i] = dp[i] || dp[j];
                }
            }
        }

        return dp[n];
    }
}