package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || p == null || p.length() > s.length()) {
            return new ArrayList<>();
        }
        int len1 = s.length();
        int len2 = p.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < len2; i++) {
            freq1[s.charAt(i) - 'a']++;
            freq2[p.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (Arrays.equals(freq1, freq2)) {
            res.add(0);
        }
        for (int i = len2; i < len1; i++) {
            freq1[s.charAt(i) - 'a']++;
            freq1[s.charAt(i - len2) - 'a']--;
            if (Arrays.equals(freq1, freq2)) {
                res.add(i - len2 + 1);
            }
        }
        return res;
    }
}
