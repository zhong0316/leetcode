package org.whuims.leetcode.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int res = tsc.threeSumClosest(new int[]{1, 2, 4, 8, 16, 32, 64, 128}, 82);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Map<Integer, Integer> res = new TreeMap<>();
        for (int i = 0; i <= nums.length / 2; i++) {
            int num = nums[i];
            helper(nums, num, i + 1, nums.length - 1, target, res);
        }
        return res.entrySet().iterator().next().getValue();
    }

    private void helper(int[] nums, int num, int start, int end, int target, Map<Integer, Integer> res) {
        if (start >= end) {
            return;
        }
        res.put(Math.abs(nums[start] + nums[end] + num - target), nums[start] + nums[end] + num);
        if (nums[start] + nums[end] + num == target) {
            return;
        } else if (nums[start] + nums[end] + num < target) {
            helper(nums, num, start + 1, end, target, res);
        } else {
            helper(nums, num, start, end - 1, target, res);
        }
    }
}
