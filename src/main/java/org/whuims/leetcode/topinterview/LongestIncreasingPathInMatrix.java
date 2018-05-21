package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPathInMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        LongestIncreasingPathInMatrix longestIncreasingPathInMatrix = new LongestIncreasingPathInMatrix();
        int res = longestIncreasingPathInMatrix.longestIncreasingPath(matrix);
        System.out.println(res);
    }

    Map<String, Integer> cache = new HashMap<>();

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(dfs(matrix, i, j, m, n), max);
            }
        }
        return max + 1;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n) {
        String cacheKey = i + "_" + j;
        if (cache.containsKey(cacheKey)) {
            return cache.get(cacheKey);
        }
        if (i >= m || j >= n || i < 0 || j < 0) {
            return 0;
        }
        // go top
        int num1 = 0;
        if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
            num1 = dfs(matrix, i - 1, j, m, n) + 1;
        }
        // go down
        int num2 = 0;
        if (i < m - 1 && matrix[i][j] > matrix[i + 1][j]) {
            num2 = dfs(matrix, i + 1, j, m, n) + 1;
        }
        // go left
        int num3 = 0;
        if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
            num3 = dfs(matrix, i, j - 1, m, n) + 1;
        }
        // go right
        int num4 = 0;
        if (j < n - 1 && matrix[i][j] > matrix[i][j + 1]) {
            num4 = dfs(matrix, i, j + 1, m, n) + 1;
        }
        int res = Math.max(Math.max(Math.max(num1, num2), num3), num4);
        cache.put(cacheKey, res);
        return res;
    }
}
