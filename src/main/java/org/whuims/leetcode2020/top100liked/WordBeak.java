package org.whuims.leetcode2020.top100liked;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBeak {

    public static void main(String[] args) {
        WordBeak w = new WordBeak();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
                "aaaaaaaaa", "aaaaaaaaaa");
        System.out.println(w.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> dict) {
        return wordBreak(s, new HashSet(dict));
    }

    public boolean wordBreak(String s, Set<String> dict) {
        int len = s.length();
        boolean[] loca = new boolean[len + 1];
        loca[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                // 前j-1个元素in dict且第j~i-1个元素构成的单词in dict，则判断loca[i] = true
                if (loca[j] && dict.contains(s.substring(j, i))) {
                    loca[i] = true;
                    break;
                }
            }
        }
        return loca[len];
    }
}