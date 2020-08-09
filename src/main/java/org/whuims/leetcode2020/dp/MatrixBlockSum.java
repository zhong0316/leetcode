package org.whuims.leetcode2020.dp;

public class MatrixBlockSum {

    public static void main(String[] args) {
        MatrixBlockSum m = new MatrixBlockSum();
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(m.matrixBlockSum(mat, 1));
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] - dp[i][j] + mat[i][j];
            }
        }

        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - K);
                int r2 = Math.min(i + K + 1, m);
                int c1 = Math.max(0, j - K);
                int c2 = Math.min(j + K + 1, n);

                res[i][j] = dp[r2][c2] - dp[r2][c1] - dp[r1][c2] + dp[r1][c1];
            }
        }

        return res;
    }
}