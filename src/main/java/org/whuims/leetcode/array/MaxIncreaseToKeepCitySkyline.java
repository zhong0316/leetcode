package org.whuims.leetcode.array;

public class MaxIncreaseToKeepCitySkyline {

    public static void main(String[] args) {

    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int[] maxLine = new int[m];
        int[] maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLine[i] = Math.max(maxLine[i], grid[i][j]);
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cell = grid[i][j];
                int availableMax = Math.min(maxLine[i], maxCol[j]);
                res += availableMax - cell;
            }
        }
        return res;
    }
}
