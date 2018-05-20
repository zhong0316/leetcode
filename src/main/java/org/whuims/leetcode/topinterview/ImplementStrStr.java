package org.whuims.leetcode.topinterview;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }

        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 > len1) {
            return -1;
        }
        int out = 0;
        while (out < len1) {
            int temp = out;
            int delta = 0;
            while (out < len1 && delta < len2 && haystack.charAt(out++) == needle.charAt(delta)) {
                delta++;
            }
            if (delta == len2) {
                return temp;
            } else {
                out = temp + 1;
            }
        }
        return -1;
    }
}
