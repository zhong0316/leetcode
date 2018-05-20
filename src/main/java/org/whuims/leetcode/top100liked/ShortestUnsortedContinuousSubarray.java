package org.whuims.leetcode.top100liked;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);

        int start = 0;
        while (start < n && nums[start] == temp[start]) {
            start++;
        }

        int end = n - 1;
        while (end > start && nums[end] == temp[end]) {
            end--;
        }

        return end - start + 1;
    }
}
