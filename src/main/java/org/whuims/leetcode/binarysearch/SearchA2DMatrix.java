package org.whuims.leetcode.binarysearch;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            int num = matrix[i][j];
            if (target == num) {
                return true;
            } else if (num < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
