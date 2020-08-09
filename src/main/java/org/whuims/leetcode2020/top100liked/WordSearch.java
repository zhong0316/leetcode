package org.whuims.leetcode2020.top100liked;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' }, };
        // char[][] board = { { 'a' } };
        String word = "ABFDAS";
        System.out.println(w.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, word, 0, new boolean[m][n], i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtracking(char[][] board, String word, int index, boolean[][] visit, int i, int j) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visit[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        visit[i][j] = true;
        if (backtracking(board, word, index + 1, visit, i - 1, j)) {
            return true;
        }
        if (backtracking(board, word, index + 1, visit, i + 1, j)) {
            return true;
        }
        if (backtracking(board, word, index + 1, visit, i, j + 1)) {
            return true;
        }

        if (backtracking(board, word, index + 1, visit, i, j - 1)) {
            return true;
        }
        visit[i][j] = false;

        return false;
    }
}