package org.whuims.leetcode.top100liked;

public class HouseRobber {

    // f(i) = a[i], i == 0;
    // f(i) = max(f(j)) + i;
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return dp(nums, nums.length - 1);
    }

    int dp(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }
        if (index == 1) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int curr = dp(nums, 1);
        int pre = dp(nums, 0);
        for (int i = 2; i <= index; i++) {
            if (pre + nums[i] > curr) {
                int temp = curr;
                curr = pre + nums[i];
                pre = temp;
            } else pre = curr;
        }
        return curr;
    }
}
