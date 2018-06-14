package org.whuims.leetcode.dp;

public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean res = isSubsequence.isSubsequence("ad", "adf");
        System.out.println(res);
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int len1 = sc.length;
        int len2 = tc.length;
        return dp(sc, 0, tc, 0, len1, len2);
    }

    private boolean dp(char[] sc, int i, char[] tc, int j, int len1, int len2) {
        int counter = 0;
        while (i < len1 && j < len2) {
            if (sc[i] == tc[j]) {
                counter++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return counter == len1;
    }
}