package org.whuims.leetcode.twopointers;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int res = removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
        System.out.println(res);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0, j = 0;
        int counter = 0;
        int duplicates = 0;
        while (i < len && j < len) {
            while (j < len && nums[j] == nums[i]) {
                j++;
                counter++;
            }
            if (counter > 2) {
                int start = i + 2;
                int howMany = counter - 2;
                duplicates += howMany;
                len -= howMany;
                removeDuplicates(start, nums, howMany);
                i = j -= howMany;
            } else {
                i = j;
            }
            counter = 0;
        }
        return nums.length - duplicates;
    }

    private void removeDuplicates(int start, int[] nums, int howMany) {
        for (int i = start + howMany; i < nums.length; i++) {
            nums[i - howMany] = nums[i];
            nums[i] = Integer.MIN_VALUE;
        }
    }
}
