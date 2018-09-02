package org.whuims.leetcode.array;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] >= 0 || (nums[0] < 0 && nums[1] >= 0)) {
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        } else {
            return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
        }
    }
}
