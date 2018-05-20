package org.whuims.leetcode.topinterview;

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        long left = mid - 1 >= 0 ? nums[mid - 1] : Long.MIN_VALUE;
        long right = mid + 1 <= nums.length - 1 ? nums[mid + 1] : Long.MIN_VALUE;
        if (nums[mid] > left && nums[mid] > right) {
            return mid;
        } else {
            int leftIndex = findPeak(nums, start, mid - 1);
            if (leftIndex != -1) {
                return leftIndex;
            } else {
                int rightIndex = findPeak(nums, mid + 1, end);
                return rightIndex;
            }
        }
    }
}
