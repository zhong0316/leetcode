package org.whuims.leetcode.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        String s = "aaaaaaaa";
        String[] words = {"aa", "aa", "aa"};
        List<Integer> res = substringWithConcatenationOfAllWords.findSubstring(s, words);
        res.forEach(System.out::println);
    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        if (words.length == 0 || words[0].length() == 0) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                res.add(i);
            }
            return res;
        }
        int len = s.length(), start = 0, end = 0;
        int n = words.length, window = n * words[0].length(), wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        while (start < len && end < len) {
            while (start + window <= len && !map.containsKey(s.substring(start, start + wordLen))) start++;
            end = start + window;
            if (end > len) break;
            if (candidate(start, s, map, wordLen, n)) {
                res.add(start);
            }
            start++;
        }
        return res;
    }

    private boolean candidate(int start, String s, Map<String, Integer> map, int wordLen, int n) {
        Map<String, Integer> curr = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = s.substring(start, start + wordLen);
            start += wordLen;
            curr.put(word, curr.getOrDefault(word, 0) + 1);
        }
        return !map.entrySet().stream().filter(o -> curr.get(o.getKey()) != o.getValue()).findAny().isPresent();
    }
}
