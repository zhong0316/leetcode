package org.whuims.leetcode.dp;

/**
 * 931. Minimum Falling Path Sum
 * Medium
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 */
public class MinimumFallingPathSum {

    public static void main(String[] args){
        MinimumFallingPathSum minimumFallingPathSum = new MinimumFallingPathSum();
        int[][] A = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(minimumFallingPathSum.minFallingPathSum(A));
    }

    public int minFallingPathSum(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m][n];
        for (int k = 0; k < n; k++) dp[0][k] = A[0][k];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][Math.max(j - 1, 0)], Math.min(dp[i - 1][Math.min(j + 1, n - 1)], dp[i - 1][j]));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : dp[m - 1]) res = Math.min(res, i);
        return res;
    }
}
