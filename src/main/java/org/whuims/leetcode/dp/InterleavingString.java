package org.whuims.leetcode.dp;

public class InterleavingString {

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null || s3.length() == 0) {
            return (s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0);
        }
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }
        // dp[i][j]:到s1的第i个字符和到s2的第j个字符为止，s3目前是否符合
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) ||
                        dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
            }
        }
        return dp[len1][len2];
    }
}
