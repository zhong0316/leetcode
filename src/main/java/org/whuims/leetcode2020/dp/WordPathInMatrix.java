package org.whuims.leetcode2020.dp;

/**
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/submissions/
 */
public class WordPathInMatrix {

    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, board, visit, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int i, int j, char[][] board, boolean[][] visit, String word, int idx) {
        if (visit[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        if (idx == word.length() - 1) {
            return true;
        }
        visit[i][j] = true;
        for (int k = 0; k < dir.length; k++) {
            int[] dirs = dir[k];
            if (dirs[0] + i < 0 || dirs[0] + i >= board.length) {
                continue;
            }
            if (dirs[1] + j < 0 || dirs[1] + j >= board[0].length) {
                continue;
            }
            if (helper(i + dirs[0], j + dirs[1], board, visit, word, idx + 1)) {
                return true;
            }
        }

        visit[i][j] = false;
        return false;
    }
}