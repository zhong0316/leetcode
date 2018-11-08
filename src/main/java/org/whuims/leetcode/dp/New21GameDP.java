package org.whuims.leetcode.dp;

public class New21GameDP {

    public static void main(String[] args) {
        New21GameDP new21GameDP = new New21GameDP();
        double res = new21GameDP.new21Game(21, 17, 10);
        System.out.println(res);
    }
//    public double new21Game(int N, int K, int W) {
//        if (K == 0 || N >= K - 1 + W) return 1;
//        int max = K - 1 + W;
//        double[] dp = new double[max + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= max; i++) {
//            for (int j = 1; j <= W; j++) {
//                if (i - j >= 0 && i - j < K) {
//                    dp[i] += dp[i - j] / W;
//                }
//            }
//        }
//        double res = 0.0d;
//        for (int i = K; i <= N; i++) {
//            res += dp[i];
//        }
//        return res;
//    }

    /**
     * Intuition:
     * The same problems as "Climbing Stairs".
     *
     * Explanation:
     * In a word,
     * dp[i]: probability of get points i
     * dp[i] = sum(last W dp values) / W
     *
     * To get Wsum = sum(last W dp values), we can maintain a sliding window with size at most K.
     * @param N
     * @param K
     * @param W
     * @return
     */
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K - 1 + W) return 1;
        double[] dp = new double[N + 1];
        double res = 0.0d;
        dp[0] = 1;
        double wSum = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = wSum / W;
            if (i < K) {
                wSum += dp[i];
            } else {
                res += dp[i];
            }
            if (i - W >= 0) {
                wSum -= dp[i - W];
            }
        }
        return res;
    }
}
