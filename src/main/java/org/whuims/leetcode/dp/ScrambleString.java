package org.whuims.leetcode.dp;

public class ScrambleString {

    public static void main(String[] args) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("rgtea", "great"));
    }
//    public boolean isScramble(String s1, String s2) {
//        if (s1 == null || s2 == null || s1.length() != s2.length()) {
//            return false;
//        }
//        if (s2.length() == 0) {
//            return false;
//        }
//        int n = s1.length();
//        boolean[][][] res = new boolean[n][n][n + 1];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
//            }
//        }
//        for (int len = 2; len <= n; len++) {
//            for (int i = 0; i < n - len + 1; i++) {
//                for (int j = 0; j < n - len + 1; j++) {
//                    for (int k = 1; k < len; k++) {
//                        res[i][j][len] |= res[i][j][k] && res[i + k][j + k][len - k] || res[i][j + len - k][k] && res[i + k][j][len - k];
//                    }
//                }
//            }
//        }
//        return res[0][0][n];
//    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) if (letters[i] != 0) return false;

        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

}
