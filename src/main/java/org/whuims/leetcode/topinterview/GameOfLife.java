package org.whuims.leetcode.topinterview;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = live(board, i, j, m, n);
                if ((board[i][j] == 1 || board[i][j] == 3) && (live == 2 || live == 3)) {
                    board[i][j] = 3;
                } else {
                    board[i][j] = live == 3 ? 2 : board[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int live(int[][] board, int x, int y, int m, int n) {
        int live = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if ((newX == x) && (newY == y)) {
                    continue;
                }
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && (board[newX][newY] == 1 || board[newX][newY] == 3)) {
                    live++;
                }
            }
        }
        return live;
    }
}
