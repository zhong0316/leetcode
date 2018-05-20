package org.whuims.leetcode.top100liked;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, i, j, word, 0, new boolean[row][col])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, String word, int index, boolean[][] visit) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean result = search(board, i - 1, j, word, index + 1, visit) || search(board, i, j - 1, word, index + 1, visit)
                || search(board, i + 1, j, word, index + 1, visit) || search(board, i, j + 1, word, index + 1, visit);
        visit[i][j] = false;
        return result;
    }
}
