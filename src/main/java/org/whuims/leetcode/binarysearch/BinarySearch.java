package org.whuims.leetcode.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int numMid = nums[mid];
            if (numMid == target) {
                return mid;
            } else if (numMid > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
