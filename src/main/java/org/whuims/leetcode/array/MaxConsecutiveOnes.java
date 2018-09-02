package org.whuims.leetcode.array;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1};
        int res = maxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(res);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter = 0;
            }
            res = Math.max(res, counter);
        }
        return res;
    }
}
