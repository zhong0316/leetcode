package org.whuims.leetcode2020.top100liked;

public class KthLargestInArray {

    public static void main(String[] args) {
        int[] nums = { 3, 3, 3, 3, 3, 3, 3, 3, 3 };
        KthLargestInArray kthLargestInArray = new KthLargestInArray();
        System.out.println(kthLargestInArray.findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[start];
        }
        int mid = partition(nums, start, end);
        if (mid == k) {
            return nums[mid];
        } else if (mid > k) {
            return helper(nums, k, start, mid - 1);
        }
        return helper(nums, k, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int low = start;
        int high = end + 1;
        int pivot = nums[start];
        while (true) {
            while (nums[++low] < pivot) {
                if (low == end) {
                    break;
                }
            }
            while (nums[--high] > pivot) {
                if (high == start) {
                    break;
                }
            }
            if (low >= high) {
                break;
            }
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
        }

        int tmp = nums[start];
        nums[start] = nums[high];
        nums[high] = tmp;

        return high;
    }
}