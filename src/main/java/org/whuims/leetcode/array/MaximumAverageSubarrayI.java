package org.whuims.leetcode.array;

public class MaximumAverageSubarrayI {

    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0;
        }
        int len = nums.length;
        double window = 0.0d;
        for (int i = 0; i < k; i++) {
            window += (double) nums[i] / k;
        }
        double res = window;
        for (int i = k; i < len; i++) {
            window -= (double) nums[i - k] / k;
            window += (double) nums[i] / k;
            res = Math.max(res, window);
        }
        return res;
    }
}
