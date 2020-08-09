package org.whuims.leetcode2020.dp;

public class FreedomTrail {

    public static void main(String[] args) {
        FreedomTrail f = new FreedomTrail();
        String ring = "godding";
        String key = "gd";
        System.out.println(f.findRotateSteps(ring, key));
    }

    /**
     * 太难了
     * 
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        // 其中dp[i][j]表示转动从i位置开始的key串所需要的最少步数(这里不包括spell的步数，
        // 因为spell可以在最后统一加上)，此时表盘的12点位置是ring中的第j个字。
        int[][] dp = new int[m + 1][n];
        for (int i = m - 1; i >= 0; i--) {
            char c1 = key.charAt(i);
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (c1 == ring.charAt(k)) {
                        int diff = Math.abs(k - j);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k] + step);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }
}