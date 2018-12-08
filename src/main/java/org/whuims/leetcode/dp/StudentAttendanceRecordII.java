package org.whuims.leetcode.dp;

/**
 * @author zhaozhongwei1
 */
public class StudentAttendanceRecordII {

    public int checkRecord(int n) {
        int mod = 1000000007;
        // dp[i][j][k]到i为止，最多有j个A和连续k个L的记录
        int[][][] dp = new int[n + 1][2][3];
        dp[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    int val = dp[i - 1][j][2];
                    if (j > 0) {
                        // ...A
                        val = (val + dp[i - 1][j - 1][2]) % mod;
                    }
                    if (k > 0) {
                        // ...L
                        val = (val + dp[i - 1][j][k - 1]) % mod;
                    }
                    dp[i][j][k] = val;
                }
            }
        }
        return dp[n][1][2];
    }
}
