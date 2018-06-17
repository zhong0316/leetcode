package org.whuims.leetcode.dp;

import java.util.*;

public class CombinationSumIV {

    public static void main(String[] args) {
        CombinationSumIV combinationSumIV = new CombinationSumIV();
        int[] nums = {4,2,1};
        Arrays.sort(nums);
        int target = 32;
        int res = combinationSumIV.combinationSum4(nums, target);
        System.out.println(res);
    }

    public int solve(int nums[], int target, int dp[]) {
        if (target <= 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int i = nums.length - 1; i > -1; i--) {
            if (target - nums[i] >= 0) {
                count += solve(nums, target - nums[i], dp);
            }
        }
        return dp[target] = count;
    }


    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        return solve(nums, target, dp);
    }
}
