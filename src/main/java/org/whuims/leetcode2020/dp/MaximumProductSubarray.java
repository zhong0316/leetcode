package org.whuims.leetcode2020.dp;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums = { 2, 3, 0, -2, 4, -2 };
        System.out.println(m.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = max;
            max = Math.max(nums[i], Math.max(min * nums[i], max * nums[i]));
            min = Math.min(nums[i], Math.min(nums[i] * tmp, nums[i] * min));
            res = Math.max(res, max);
        }

        return res;
    }
}