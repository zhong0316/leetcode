package org.whuims.leetcode.array;

public class TransformToChessboard {

    public static void main(String[] args) {
        TransformToChessboard transformToChessboard = new TransformToChessboard();
        int[][] board = {{0, 1}, {1, 0}};
        int res = transformToChessboard.movesToChessboard(board);
        System.out.println(res);
    }

    public int movesToChessboard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((board[0][0] ^ board[i][0] ^ board[0][j] ^ board[i][j]) == 1) {
                    return -1;
                }
            }
        }
        int rowSwap = 0, colSwap = 0;
        int rowSum = 0, colSum = 0;
        for (int i = 0; i < n; i++) {
            if (board[0][i] == i % 2) rowSwap++;
            if (board[i][0] == i % 2) colSwap++;
            colSum += board[i][0];
            rowSum += board[0][i];
        }
        if (rowSum < n / 2 || rowSum > (n + 1) / 2) return -1;
        if (colSum < n / 2 || colSum > (n + 1) / 2) return -1;
        if (n % 2 == 1) {
            if (rowSwap % 2 == 1) rowSwap = n - rowSwap;
            if (colSwap % 2 == 1) colSwap = n - colSwap;
        } else {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        }
        return (rowSwap + colSwap) / 2;
    }
}
