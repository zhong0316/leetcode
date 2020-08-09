package org.whuims.leetcode2020.dp;

public class LongestPalindromicSubstring {

    int maxLen = 0;
    String res = "";

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "abcaba";
        long start = System.currentTimeMillis();
        System.out.println(lps.longestPalindrome(s));
        System.out.println(System.currentTimeMillis() - start);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        for (int i = 0; i < n - 1; i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return res;
    }

    private void expand(String s, int i, int j) {
        int n = s.length();
        while (i >= 0 && j < n) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            if (j - i + 1 > maxLen) {
                res = s.substring(i, j + 1);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            i--;
            j++;
        }
    }
}