package org.whuims.leetcode.top100liked;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int p1 = 0, p2 = 0, len = nums.length;
        while (p1 < len && p2 < len) {
            while (p1 < len && nums[p1] == 0) {
                p1++;
            }
            while (p2 < len && nums[p2] != 0) {
                p2++;
            }
            if (p1 < len && p2 < len) {
                if (p1 < p2 && nums[p1] == 0 && nums[p2] != 0) {
                    swap(nums, p1, p2);
                } else if (p1 > p2 && nums[p1] != 0 && nums[p2] == 0) {
                    swap(nums, p1, p2);
                } else {
                    p1++;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
