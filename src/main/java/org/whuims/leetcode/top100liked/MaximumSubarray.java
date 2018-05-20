package org.whuims.leetcode.top100liked;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSofar = nums[0], maxCur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], nums[i] + maxCur);
            maxSofar = Math.max(maxCur, maxSofar);
        }
        return maxSofar;
    }
}
