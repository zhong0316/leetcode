package org.whuims.leetcode.dp;

public class CherryPickup {

    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        int[][] grid = new int[][]{{1,1,-1},{1,-1,1},{-1,1,1}};
        System.out.println(cherryPickup.cherryPickup(grid));
    }

//    public int cherryPickup(int[][] grid) {
//        int res = 0;
//        int n = grid.length;
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                dp[i][j] = grid[i][j];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == -1) continue;
//                if (i == 0 && j == 0) continue;
//                if (i > 0 && j > 0) {
//                    if (grid[i - 1][j] == -1 && grid[i][j - 1] == -1) return 0;
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
//                } else if (i == 0) {
//                    dp[i][j] = dp[i][j - 1] + grid[i][j];
//                } else dp[i][j] = dp[i - 1][j] + grid[i][j];
//            }
//        }
//        res += dp[n - 1][n - 1];
//        int i = 0, j = 0;
//        while (i < n && j < n) {
//            grid[i][j] = 0;
//            if (i == 0 && j > 0) {
//                // go down
//                i++;
//            } else if (i > 0 && j == 0) {
//                // go right
//                j++;
//            } else {
//                if (i < n - 1 && j < n - 1 && dp[i + 1][j] >= dp[i][j + 1]) {
//                    i++;
//                } else {
//                    j++;
//                }
//            }
//        }
//        for (i = 0; i < n; i++) {
//            for (j = 0; j < n; j++) dp[i][j] = grid[i][j];
//        }
//        for (i = n - 1; i >= 0; i--) {
//            for (j = n - 1; j >= 0; j--) {
//                if (grid[i][j] == -1) continue;
//                if (i == n - 1 && j == n - 1) continue;
//                if (i < n - 1 && j < n - 1) {
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
//                } else if (i == n - 1) {
//                    dp[i][j] = dp[i][j + 1] + grid[i][j];
//                } else dp[i][j] = dp[i + 1][j] + grid[i][j];
//            }
//        }
//        res += dp[0][0];
//        return res;
//    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int k = 1; k < 2 * n - 1; k++) {
            for (int i = n - 1; i >= 0; i--) {
                for (int p = n - 1; p >= 0; p--) {
                    int j = k - i, q = k - p;
                    if (j < 0 || j >= n || q < 0 || q >= n || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp[i][p] = -1;
                        continue;
                    }
                    if (i > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p]);
                    if (p > 0) dp[i][p] = Math.max(dp[i][p], dp[i][p - 1]);
                    if (i > 0 && p > 0) dp[i][p] = Math.max(dp[i][p], dp[i - 1][p - 1]);
                    if (dp[i][p] >= 0) dp[i][p] += grid[i][j] + (i == p ? 0 : grid[p][q]);
                }
            }
        }
        return Math.max(0, dp[n - 1][n - 1]);
    }
}
