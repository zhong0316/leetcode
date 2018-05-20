package org.whuims.leetcode.top100liked;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int rotateIndex = findRotateIndex(nums);
        int index1 = binarySearch(nums, 0, rotateIndex, target);
        int index2 = binarySearch(nums, rotateIndex + 1, nums.length - 1, target);
        if (index1 != -1) {
            return index1;
        } else if (index2 != -1) {
            return index2;
        } else {
            return -1;
        }
    }

    private int findRotateIndex(int[] nums) {
        int i = 0;
        while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        return i;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start++;
            } else {
                end--;
            }
        }
        return -1;
    }

}
