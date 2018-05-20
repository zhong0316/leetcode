package org.whuims.leetcode.topinterview;

public class ReverseString {

    public String reverseString(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        char[] val = s.toCharArray();
        int i = 0;
        int j = val.length - 1;
        while (true) {
            if (i >= j) {
                break;
            }
            swap(val, i++, j--);
        }
        return new String(val);
    }

    void swap(char[] val, int i, int j) {
        if (i == j) {
            return;
        }
        val[i] ^= val[j];
        val[j] ^= val[i];
        val[i] ^= val[j];
    }
}
