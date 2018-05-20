package org.whuims.leetcode.top100liked;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, nums.length - k, 0, nums.length - 1);
    }

    public int findKth(int[] nums, int k, int low, int high) {
        if (low >= high) {
            return nums[low];
        }
        int pivot = partition(nums, low, high);
        if (pivot == k) {
            return nums[pivot];
        } else if (pivot < k) {
            return findKth(nums, k, pivot + 1, high);
        } else {
            return findKth(nums, k, low, pivot - 1);
        }
    }

    int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        int pivot = nums[low];
        while (true) {
            while (less(nums[++i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (less(pivot, nums[--j])) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    boolean less(int i, int j) {
        return i < j;
    }

    void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
