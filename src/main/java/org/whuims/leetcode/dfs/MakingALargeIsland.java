package org.whuims.leetcode.dfs;

public class MakingALargeIsland {

    public static void main(String[] args) {
        MakingALargeIsland makingALargeIsland = new MakingALargeIsland();
//        int[][] grid = {{1, 1, 1, 0}, {0, 1, 0, 0}, {1, 0, 1, 1}};
        int[][] grid = {{1, 1}, {1, 1}};
        System.out.println(makingALargeIsland.largestIsland(grid));
    }

    public int largestIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid, m, n, visited));
                }
            }
        }
        refill(visited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && (((i > 0 && grid[i - 1][j] == 1) || (i < m - 1 && grid[i + 1][j] == 1) ||
                        (j > 0 && grid[i][j - 1] == 1) || (j < n - 1 && grid[i][j + 1] == 1)))) {
                    grid[i][j] = 1;
                    res = Math.max(res, dfs(i, j, grid, m, n, visited));
                    refill(visited);
                    grid[i][j] = 0;
                }
            }
        }
        return res == 0 ? 1 : res;
    }

    private int dfs(int i, int j, int[][] grid, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1) return 0;
        int res = 1;
        visited[i][j] = true;
        if (i > 0) res += dfs(i - 1, j, grid, m, n, visited);
        if (i < m - 1) res += dfs(i + 1, j, grid, m, n, visited);
        if (j > 0) res += dfs(i, j - 1, grid, m, n, visited);
        if (j < n - 1) res += dfs(i, j + 1, grid, m, n, visited);
        return res;
    }

    private void refill(boolean[][] visited) {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) visited[i][j] = false;
        }
    }
}
