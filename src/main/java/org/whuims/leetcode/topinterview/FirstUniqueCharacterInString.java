package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        if (s.length() == 1) {
            return 0;
        }
        int len = s.length();
        Map<Character, Integer> fre = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (fre.containsKey(c)) {
                fre.put(c, fre.get(c) + 1);
            } else {
                fre.put(c, 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (fre.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
