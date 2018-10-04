package org.whuims.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0) return str == null || str.length() == 0;
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> reverseMap = new HashMap<>();
        String[] arr = str.split(" ");
        int len = pattern.length();
        if (arr.length != len) return false;
        for (int i = 0; i < len; i++) {
            char c = pattern.charAt(i);
            if ((map.containsKey(c) && !arr[i].equals(map.get(c))) ||
                    reverseMap.containsKey(arr[i]) && c != reverseMap.get(arr[i])) {
                return false;
            } else {
                map.put(c, arr[i]);
                reverseMap.put(arr[i], c);
            }
        }
        return true;
    }
}
