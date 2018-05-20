package org.whuims.leetcode.topinterview;

import java.util.Arrays;

public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = (n + 1) / 2, right = n;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = ((i & 1) == 0) ? nums[--left] : nums[--right];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}
