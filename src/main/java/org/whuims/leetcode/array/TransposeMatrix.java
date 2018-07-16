package org.whuims.leetcode.array;

public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int m = A.length, n = A[0].length;
        int[][] B = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
