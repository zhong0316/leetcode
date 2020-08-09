package org.whuims.leetcode2020.top100liked;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int[] nums = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int target = 3;
        System.out.println(s.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        int start = 0;
        int end = pivot;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = pivot + 1;
        end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int findPivot(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if (mid < nums.length - 1 && nums[mid + 1] < nums[mid]) {
            return mid;
        }

        if (nums[start] > nums[mid]) {
            return findPivot(nums, start, mid);
        }

        if (nums[mid] > nums[end]) {
            return findPivot(nums, mid, end);
        }

        return -1;
    }
}