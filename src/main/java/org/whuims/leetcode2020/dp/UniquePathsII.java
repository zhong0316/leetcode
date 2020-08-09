package org.whuims.leetcode2020.dp;

public class UniquePathsII {

    public static void main(String[] args) {
        UniquePathsII u = new UniquePathsII();
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(u.uniquePathsWithObstacles(grid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                flag = true;
            } else {
                dp[i][0] = 1;
            }
        }

        flag = false;
        for (int i = 0; i < n; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                flag = true;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1 || (obstacleGrid[i - 1][j] == 1 && obstacleGrid[i][j - 1] == 1)) {
                    dp[i][j] = 0;
                } else {
                    if (dp[i - 1][j] > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (dp[i][j - 1] > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}