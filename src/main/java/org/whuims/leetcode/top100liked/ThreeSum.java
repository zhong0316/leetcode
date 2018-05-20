package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            bSearch(nums, i + 1, nums.length - 1, -num, ret, i);
        }
        return ret;
    }

    private void bSearch(int[] nums, int start, int end, int targetTotal, List<List<Integer>> ret, int index) {
        int i = start, j = end;
        while (i < j) {
            if (targetTotal == nums[i] + nums[j]) {
                List<Integer> oneShot = new ArrayList<>();
                oneShot.add(nums[index]);
                oneShot.add(nums[i]);
                oneShot.add(nums[j]);
                ret.add(oneShot);
                while (i < j && nums[i] == nums[i + 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j - 1]) {
                    j--;
                }
                i++;
                j--;
            } else if (nums[i] + nums[j] > targetTotal) {
                j--;
            } else {
                i++;
            }
        }
    }
}
