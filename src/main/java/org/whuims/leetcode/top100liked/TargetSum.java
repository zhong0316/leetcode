package org.whuims.leetcode.top100liked;

public class TargetSum {

    int solution = 0;

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, S);
        return solution;
    }

    private void dfs(int[] nums, int index, int s) {
        if (index == nums.length) {
            if (s == 0) {
                solution++;
            }
            return;
        }
        dfs(nums, index + 1, s - nums[index]);
        dfs(nums, index + 1, s + nums[index]);
    }
}
