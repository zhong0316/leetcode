package org.whuims.leetcode2020.dp;

/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ≤ n ≤ 1000 1 ≤ m ≤ min(50, n) Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 */
public class SplitArrayLargestSum {

    public static void main(String[] args) {
        SplitArrayLargestSum s = new SplitArrayLargestSum();
        int[] arr = { 7, 2, 5, 10, 8, 3 };
        int m = 2;
        System.out.println(s.splitArray(arr, m));
    }

    public int splitArray(int[] arr, int m) {
        int n = arr.length;
        int[] sum = new int[n + 1];
        // dp[i][j]：arr前i个数分割成m个子数组的 minimum largest sum subarray
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
            dp[i][1] = sum[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }

        return dp[n][m];
    }
}