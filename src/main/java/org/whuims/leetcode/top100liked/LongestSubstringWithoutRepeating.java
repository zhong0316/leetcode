package org.whuims.leetcode.top100liked;

public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int[] loc = new int[256];
        int left = 0;
        for (int k = 0; k < 256; k++) {
            loc[k] = -1;
        }
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (loc[chars[i]] >= left) {
                left = loc[chars[i]] + 1;
            }
            loc[chars[i]] = i;
            max = max > i - left + 1 ? max : i - left + 1;
        }
        return max;
    }
}
