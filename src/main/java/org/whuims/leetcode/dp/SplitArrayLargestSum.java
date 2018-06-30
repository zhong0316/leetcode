package org.whuims.leetcode.dp;

public class SplitArrayLargestSum {

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int[] nums = {7, 2, 5, 10, 8};
        int res = splitArrayLargestSum.splitArray(nums, 5);
        System.out.println(res);
    }

    public int splitArray(int[] nums, int m) {
        int[][] memo = new int[nums.length][m + 1];
        int[] sum = new int[nums.length];
        sum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + nums[i];
        }
        return dfs(nums, 0, m, sum, memo);
    }

    public int dfs(int[] nums, int start, int m, int[] sums, int[][] memo) {
        if (m == 1) {
            return sums[start];
        }
        if (memo[start][m] > 0) {
            return memo[start][m];
        }
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i = start; i <= nums.length - m; i++) {
            sum += nums[i];
            min = Math.min(Math.max(sum, dfs(nums, i + 1, m - 1, sums, memo)), min);
        }
        memo[start][m] = min;
        return memo[start][m];
    }
}
