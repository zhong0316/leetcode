package org.whuims.leetcode.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public static void main(String[] args) {
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        int[][] matrix = {{1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};
        zeroOneMatrix.updateMatrix(matrix);
        for (int[] line : matrix) {
            Arrays.stream(line).forEach(o -> System.out.print(" " + o));
            System.out.println();
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    visit[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pair = queue.poll();
                int x = pair[0], y = pair[1];
                int num = matrix[x][y];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                visit[x][y] = true;
                if (x > 0 && !visit[x - 1][y]) {
                    matrix[x - 1][y] = num + 1;
                    queue.offer(new int[]{x - 1, y});
                    visit[x - 1][y] = true;
                }
                if (x < m - 1 && !visit[x + 1][y]) {
                    matrix[x + 1][y] = num + 1;
                    queue.offer(new int[]{x + 1, y});
                    visit[x + 1][y] = true;
                }
                if (y > 0 && !visit[x][y - 1]) {
                    matrix[x][y - 1] = num + 1;
                    queue.offer(new int[]{x, y - 1});
                    visit[x][y - 1] = true;
                }
                if (y < n - 1 && !visit[x][y + 1]) {
                    matrix[x][y + 1] = num + 1;
                    queue.offer(new int[]{x, y + 1});
                    visit[x][y + 1] = true;
                }
            }
        }
        return matrix;
    }
}
