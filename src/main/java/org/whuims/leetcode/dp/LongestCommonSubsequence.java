package org.whuims.leetcode.dp;

/**
 * 77. Longest Common Subsequence
 * Given two strings, find the longest common subsequence (LCS).
 *
 * Your code should return the length of LCS.
 *
 * Example
 * Example 1:
 * 	Input:  "ABCD" and "EDCA"
 * 	Output:  1
 *
 * 	Explanation:
 * 	LCS is 'A' or  'D' or 'C'
 *
 *
 * Example 2:
 * 	Input: "ABCD" and "EACB"
 * 	Output:  2
 *
 * 	Explanation:
 * 	LCS is "AC"
 */
public class LongestCommonSubsequence {

    public static void main(String[] args){
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("ABCD", "DACB"));
    }

    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null) return 0;
        int len1 = A.length(), len2 = B.length();
        if (len1 == 0 || len2 == 0) return 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
