package org.whuims.leetcode.math;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[row][col];
            if ((row + col) % 2 == 0) {
                // go up
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else {
                // go down
                if (row == m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
