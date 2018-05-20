package org.whuims.leetcode.topinterview;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0) {
            if (t == null || t.length() == 0) {
                return true;
            } else {
                return false;
            }
        }
        int[] c1 = new int[128], c2 = new int[128];
        for (char c : s.toCharArray()) {
            c1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            c2[c - 'a']++;
        }
        return Arrays.equals(c1, c2);
    }
}
