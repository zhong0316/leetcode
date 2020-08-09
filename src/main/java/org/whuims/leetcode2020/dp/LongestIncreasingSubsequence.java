package org.whuims.leetcode2020.dp;

/**
 * 最长上升子序列
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lis(new int[] { 1, 3, 6, 7, 9, 4, 10, 5, 6 }));
    }

    public int lis(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }

        return res;
    }
}