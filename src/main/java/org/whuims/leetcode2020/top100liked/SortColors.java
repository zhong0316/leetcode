package org.whuims.leetcode2020.top100liked;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
            }
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;
                right--;
            }
        }
    }
}