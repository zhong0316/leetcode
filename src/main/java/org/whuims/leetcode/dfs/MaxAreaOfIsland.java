package org.whuims.leetcode.dfs;

public class MaxAreaOfIsland {

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int res = maxAreaOfIsland.maxAreaOfIsland(grid);
        System.out.println(res);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    // visited
                    continue;
                }
                res = Math.max(res, dfs(grid, i, j, row, col));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == 2) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        // visited
        grid[i][j] = 2;
        return 1 + dfs(grid, i + 1, j, row, col) + dfs(grid, i - 1, j, row, col) +
                dfs(grid, i, j - 1, row, col) + dfs(grid, i, j + 1, row, col);
    }
}
