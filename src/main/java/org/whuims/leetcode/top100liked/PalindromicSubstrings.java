package org.whuims.leetcode.top100liked;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        int res = len;
        for (int shift = 1; shift < len; shift++) {
            for (int i = 0; i < len - shift; i++) {
                if (isPalindromic(s, i, i + shift)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean isPalindromic(String s, int l, int r) {
        if (l == r) {
            return true;
        }
        if (l > r) {
            return false;
        }
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
