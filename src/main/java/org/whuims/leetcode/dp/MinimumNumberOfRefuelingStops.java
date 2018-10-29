package org.whuims.leetcode.dp;

public class MinimumNumberOfRefuelingStops {

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();
        int[][] stations = new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 10, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // dp[i]加i次油所能到达的最长距离
        int nSta = stations.length;
        long[] dp = new long[nSta + 1];
        dp[0] = startFuel;
        for (int i = 0; i < nSta; i++) {
            int[] station = stations[i];
            for (int j = i; j >= 0 && dp[j] >= station[0]; j--) {
                dp[i + 1] = Math.max(dp[i + 1], dp[i] + station[1]);
            }
        }
        for (int i = 0; i <= nSta; i++) {
            if (dp[i] >= target) return i;
        }
        return -1;
    }
}
