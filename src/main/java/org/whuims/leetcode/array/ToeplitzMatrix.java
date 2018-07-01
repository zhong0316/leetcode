package org.whuims.leetcode.array;

public class ToeplitzMatrix {

    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        int[][] matrix = new int[][]{{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        boolean res = toeplitzMatrix.isToeplitzMatrix(matrix);
        System.out.println(res);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int m = matrix.length, n = matrix[0].length;
        if (checkColumn(m, n, 0, 0, matrix) && checkLine(m, n, m - 1, 0, matrix)) {
            return true;
        }
        return false;
    }

    private boolean checkColumn(int m, int n, int x, int y, int[][] matrix) {
        for (int i = y; i < n; i++) {
            int val = matrix[x][i];
            int startX = x, startY = i;
            while (startX < m && startY < n) {
                if (matrix[startX][startY] != val) {
                    return false;
                } else {
                    startX++;
                    startY++;
                }
            }
        }
        return true;
    }
    private boolean checkLine(int m, int n, int x, int y, int[][] matrix) {
        for (int i = 0; i < m; i++) {
            int val = matrix[i][0];
            int startX = i, startY = 0;
            while (startX < m && startY < n) {
                if (matrix[startX][startY] != val) {
                    return false;
                } else {
                    startX++;
                    startY++;
                }
            }
        }
        return true;
    }
}
