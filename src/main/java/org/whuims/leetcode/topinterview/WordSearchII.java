package org.whuims.leetcode.topinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        WordSearchII wordSearchII = new WordSearchII();
//        char[][] boardard = new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] strings = new String[]{"oathflvren", "pea", "eat", "rain"};
        char[][] board = new char[][]{{'b', 'a', 'a', 'b', 'a', 'b'}, {'a', 'b', 'a', 'a', 'a', 'a'}, {'a', 'b', 'a', 'a', 'a', 'b'}, {'a', 'b', 'a', 'b', 'b', 'a'}, {'a', 'a', 'b', 'b', 'a', 'b'}, {'a', 'a', 'b', 'b', 'b', 'a'}, {'a', 'a', 'b', 'a', 'a', 'b'}};
        String[] strings = new String[]{"aabbbbabbaababaaaabababbaaba"};
        List<String> res = wordSearchII.findWords(board, strings);
        for (String str : res) {
            System.out.println(str);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        int m = board.length, n = board[0].length;
        Set<String> result = new HashSet<>();
        for (String str : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean[][] visit = new boolean[m][n];
                    if (backtracking(board, i, j, m, n, str.toCharArray(), 0, visit)) {
                        result.add(str);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    private boolean backtracking(char[][] board, int x, int y, int m, int n, char[] search, int index, boolean[][] visit) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (index == search.length) {
            return true;
        }
        if (search[index] != board[x][y] || visit[x][y]) {
            return false;
        }
        if (index == search.length - 1) {
            return true;
        }
        boolean res = false;
        for (int[] dir : dirs) {
            int xx = dir[0], yy = dir[1];
            visit[x][y] = true;
            res |= backtracking(board, x + xx, y + yy, m, n, search, index + 1, visit);
        }
        visit[x][y] = false;
        return res;
    }
}
