package org.whuims.leetcode.top100liked;

public class BurstBallons {

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        return helper(nums, new int[n][n], 1, 0, n - 1, 1);
    }

    private int helper(int[] nums, int[][] dp, int start, int i, int j, int end) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        for (int k = i; k <= j; k++) {
            dp[i][j] = Math.max(dp[i][j], start * nums[k] * end + helper(nums, dp, start, i, k - 1, nums[k]) + helper(nums, dp, nums[k], k + 1, j, end));
        }
        return dp[i][j];
    }
}
