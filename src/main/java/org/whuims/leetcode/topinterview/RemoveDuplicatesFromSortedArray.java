package org.whuims.leetcode.topinterview;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int diff = 1;
        int lastNumber = nums[0];
        int index = 1;
        while (index < nums.length) {
            if (nums[index] != lastNumber) {
                lastNumber = nums[index];
                diff++;
            } else {
                index++;
            }
        }
        int count = 1;
        lastNumber = nums[0];
        int i = 1;
        while (count < diff && i < nums.length) {
            if (nums[i] != lastNumber) {
                nums[count++] = nums[i];
                lastNumber = nums[i];
            } else {
                i++;
            }
        }
        return diff;
    }
}
