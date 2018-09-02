package org.whuims.leetcode.array;

public class ImageSmoother {

    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        int[][] M = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] res = imageSmoother.imageSmoother(M);
        System.out.println();
    }

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) {
            return M;
        }
        int row = M.length, col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = smooth(i, j, row, col, M);
            }
        }
        return res;
    }

    private int smooth(int i, int j, int row, int col, int[][] M) {
        int startRow = Math.max(i - 1, 0);
        int endRow = Math.min(row - 1, i + 1);
        int startCol = Math.max(j - 1, 0);
        int endCol = Math.min(col - 1, j + 1);
        int sum = 0;
        for (int k = startRow; k <= endRow; k++) {
            for (int l = startCol; l <= endCol; l++) {
                sum += M[k][l];
            }
        }
        return (int) Math.floor(sum / ((endRow - startRow + 1) * (endCol - startCol + 1)));
    }
}
