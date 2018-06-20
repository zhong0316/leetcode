package org.whuims.leetcode.dp;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) {
            return false;
        }
        int n = nums.length;
        int target = total / k;
        return dfs(nums, new boolean[n], 0, target, k, 0, 0);
    }

    private boolean dfs(int[] nums, boolean[] visit, int currSum, int target, int k, int start, int currNum) {
        if (k == 1) {
            return true;
        }
        if (currSum == target && currNum > 0) {
            return dfs(nums, visit, 0, target, k - 1, 0, 0);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                if (dfs(nums, visit, currSum + nums[i], target, k, i + 1, currNum++)) {
                    return true;
                }
                visit[i] = false;
            }
        }
        return false;
    }
}
