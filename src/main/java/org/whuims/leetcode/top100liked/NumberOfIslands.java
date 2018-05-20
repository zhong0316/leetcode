package org.whuims.leetcode.top100liked;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        boolean[][] visit = new boolean[row][col];
        int counter = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    visit(visit, grid, i, j, row, col);
                    counter++;
                }
            }
        }
        return counter;
    }

    private void visit(boolean[][] visit, char[][] grid, int i, int j, int row, int col) {
        if (i >= row || j >= col || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        visit[i][j] = true;
        if (i > 0 && grid[i - 1][j] == '1' && !visit[i - 1][j]) {
            visit(visit, grid, i - 1, j, row, col);
        }
        if (j > 0 && grid[i][j - 1] == '1' && !visit[i][j - 1]) {
            visit(visit, grid, i, j - 1, row, col);
        }
        if (j < col - 1 && !visit[i][j + 1]) {
            visit(visit, grid, i, j + 1, row, col);
        }
        if (i < row - 1 && !visit[i + 1][j]) {
            visit(visit, grid, i + 1, j, row, col);
        }
    }
}
