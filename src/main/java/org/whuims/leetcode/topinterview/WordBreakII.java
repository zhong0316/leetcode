package org.whuims.leetcode.topinterview;

import java.util.*;

public class WordBreakII {

    Map<String, List<String>> cache = new HashMap<>();

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        String s = "pineapplepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> res = wordBreakII.wordBreak(s, wordDict);
        for (String str : res) {
            System.out.println(str + " ");
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtraking(s, new HashSet<>(wordDict), new HashMap<>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> backtraking(String s, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = backtraking(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
