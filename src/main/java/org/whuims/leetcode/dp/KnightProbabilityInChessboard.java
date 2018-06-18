package org.whuims.leetcode.dp;

public class KnightProbabilityInChessboard {

    public static void main(String[] args) {
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        double res = knightProbabilityInChessboard.knightProbability(3, 2, 0, 0);
        System.out.println(res);
    }

    int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public double knightProbability(int N, int K, int r, int c) {
        double[][][] dp = new double[N][N][K+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1.0D;
            }
        }
        for (int k = 1; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    double prob = 0.0D;
                    for (int s = 0; s < 8; s++) {
                        int nx = i + dx[s];
                        int ny = j + dy[s];
                        if (inside(nx, ny, N)) {
                            prob += dp[nx][ny][k - 1] / 8.0;
                        }
                    }
                    dp[i][j][k] = prob;
                }
            }
        }
        return dp[r][c][K];
    }

    // return true if the knight is inside the board
    private boolean inside(int x, int y, int N) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
