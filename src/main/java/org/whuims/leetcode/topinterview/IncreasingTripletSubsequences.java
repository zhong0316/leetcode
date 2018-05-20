package org.whuims.leetcode.topinterview;

public class IncreasingTripletSubsequences {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int currMin = nums[0];
        int currMax = Integer.MIN_VALUE;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currMin) {
                if (nums[i] < currMax) {
                    currMax = nums[i];
                } else if (nums[i] > currMax) {
                    count++;
                    currMax = nums[i];
                }
            } else if (nums[i] < currMin) {
                currMin = nums[i];
            }
            if (count == 3) {
                return true;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }
}
