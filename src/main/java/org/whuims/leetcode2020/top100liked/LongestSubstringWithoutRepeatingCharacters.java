package org.whuims.leetcode2020.top100liked;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        String s = "tmmzuxt";
        System.out.println(l.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int n = s.length();
        int res = 0;
        int left = 0;
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pos.containsKey(c)) {
                left = Math.max(left, pos.get(c) + 1);
            }
            pos.put(c, i);
            res = Math.max(res, i - left + 1);
        }

        return res;
    }
}