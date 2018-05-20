package org.whuims.leetcode.topinterview;

import java.util.Arrays;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        //判断每一行是否有重复数字
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[i][j])) {
                    return false;
                }
            }
        }
        //判断每一列是否有重复数字
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!isValid(visited, board[j][i])) {
                    return false;
                }
            }
        }
        //判断每个子矩阵是否有重复数字
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!isValid(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isValid(boolean[] visited, char ch) {
        //判断当前位置是否为'.'，或是否被访问过
        //如果当前位置为'.'则返回true
        if (ch == '.') {
            return true;
        }

        int num = ch - '0';
        //如果当前位置访问过则返回false
        if (num < 1 || num > 9 || visited[num - 1]) {
            return false;
        }
        //将标记数字标记为true,表示该数字已访问过
        visited[num - 1] = true;
        return true;
    }
}
