package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    /**
     * 思路：从两个边界出发能达到目的地的交集
     *
     * @param matrix
     * @return
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> r = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return r;
        int m = matrix.length, n = matrix[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < m; i++) {
            dfs(dir, matrix, pacific, i, 0, Integer.MIN_VALUE);
            dfs(dir, matrix, atlantic, i, n - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dfs(dir, matrix, pacific, 0, i, Integer.MIN_VALUE);
            dfs(dir, matrix, atlantic, m - 1, i, Integer.MIN_VALUE);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1)
                    r.add(new int[]{i, j});
            }
        }
        return r;
    }


    private void dfs(int[][] dir, int[][] matrix, int[][] visited, int x, int y, int prevHeight) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] == 1 || matrix[x][y] < prevHeight) {
            return;
        }
        visited[x][y] = 1;
        for (int[] d : dir) {
            dfs(dir, matrix, visited, d[0] + x, d[1] + y, matrix[x][y]);
        }
    }
}
