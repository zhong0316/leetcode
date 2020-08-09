package org.whuims.leetcode2020.top100liked;

public class JumpGame {
    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(j.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxCan = nums[0];
        for (int i = 0; i < n; i++) {
            if (i > maxCan) {
                return false;
            }
            maxCan = Math.max(maxCan, nums[i] + i);
        }

        return maxCan >= n - 1;
    }
}