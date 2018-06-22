package org.whuims.leetcode.dp;

public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        int res = numberOfLongestIncreasingSubsequence.findNumberOfLIS(new int[]{2,2,2,2});
        System.out.println(res);
    }

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        int[] cnt = new int[len];
        int res = 0, maxLen = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        for (int num : cnt) {
            if (maxLen == num) {
                res += num;
            }
        }
        return res;
    }
}
