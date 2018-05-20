package org.whuims.leetcode.topinterview;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k <= 0 || n <= 1) {
            return;
        }
        if (k > n) {
            k -= n;
        }
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
