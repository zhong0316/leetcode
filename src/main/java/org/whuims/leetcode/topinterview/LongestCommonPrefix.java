package org.whuims.leetcode.topinterview;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int p = 0;
        int minLen = strs[0].length();
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        while (p < minLen) {
            char firstChar = strs[0].charAt(p);
            boolean allTheSame = true;
            for (String s : strs) {
                if (s.charAt(p) != firstChar) {
                    allTheSame = false;
                    break;
                }
            }
            if (allTheSame) {
                p++;
            } else {
                break;
            }
        }
        if (p == 0) {
            return "";
        }
        return strs[0].substring(0, p);
    }
}
