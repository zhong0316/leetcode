package org.whuims.leetcode.backtracking;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 6, 5};
        int[] next = nextPermutation(nums);
        Arrays.stream(next).forEach(System.out::println);
    }

    public static int[] nextPermutation(int[] nums) {
        int di = nums.length - 1;
        while (di > 0 && nums[di] < nums[di - 1]) {
            di--;
        }
        int swapLeft = di - 1;
        int swapRight = 0;
        for (int i = nums.length - 1; i >= di; i--) {
            if (nums[i] > nums[swapLeft]) {
                swapRight = i;
                break;
            }
        }
        int temp = nums[swapLeft];
        nums[swapLeft] = nums[swapRight];
        nums[swapRight] = temp;
        int start = di;
        int end = nums.length - 1;
        sort(nums, start, end);
        return nums;
    }

    private static void sort(int[] nums, int start, int end) {
        int loops = end - start;
        for (int i = 0; i < loops; i++) {
            int min = nums[start + i];
            int minIndex = i + start;
            for (int j = start + i + 1; j <= nums.length - 1; j++) {
                if (nums[j] < min) {
                    minIndex = j;
                }
            }
            swap(nums, i + start, minIndex);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
