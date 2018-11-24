package org.whuims.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        int[][] A = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(shortestBridge.shortestBridge(A));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    x = i;
                    y = j;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        dfs(A, x, y, m, n, visited, queue);
        // bfs to spread island
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int nextI = curr[0] + dir[0];
                    int nextJ = curr[1] + dir[1];
                    if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n) {
                        if (!visited[nextI][nextJ]) {
                            queue.offer(new int[]{nextI, nextJ});
                            if (A[nextI][nextJ] == 1) {
                                return step;
                            }
                            visited[nextI][nextJ] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] A, int i, int j, int m, int n, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || i == m || j < 0 || j == n) return;
        if (A[i][j] == 0 || visited[i][j]) return;
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        dfs(A, i - 1, j, m, n, visited, queue);
        dfs(A, i + 1, j, m, n, visited, queue);
        dfs(A, i, j - 1, m, n, visited, queue);
        dfs(A, i, j + 1, m, n, visited, queue);
    }
}
