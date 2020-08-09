package org.whuims.leetcode2020.top100liked;

public class MinimumPathSum {
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 }, };
        System.out.println(m.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // dp[i][j]: 到grid[i][j]时的minPathSum
        // dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = grid[i][0];
            if (i > 0) {
                dp[i][0] += dp[i - 1][0];
            }
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
            if (i > 0) {
                dp[0][i] += dp[0][i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i > 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }

        return grid[m - 1][n - 1];
    }
}