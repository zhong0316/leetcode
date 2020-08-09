package org.whuims.leetcode2020.dp;

public class Largest1BoardedSquare {

    public static void main(String[] args) {
        Largest1BoardedSquare l = new Largest1BoardedSquare();
        int[][] grid = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        System.out.println(l.largest1BorderedSquare(grid));

        String s = "abckd";
        System.out.println(s.substring(0, 1));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // top[i][j]: grid[i][j]上面有几个连续的1
        int[][] top = new int[m][n];
        int[][] left = new int[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && grid[i - 1][j] == 1) {
                    top[i][j] = top[i - 1][j] + 1;
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                }

                if (grid[i][j] == 1) {
                    res = Math.max(res, 1);
                    int r = Math.min(top[i][j], left[i][j]);
                    if (r > 0) {
                        for (int k = r; k > 0; k--) {
                            if (top[i][j - k] >= k && left[i - k][j] >= k) {
                                res = Math.max(res, (k + 1) * (k + 1));
                            }
                        }
                    }
                }
            }
        }

        return res;
    }
}