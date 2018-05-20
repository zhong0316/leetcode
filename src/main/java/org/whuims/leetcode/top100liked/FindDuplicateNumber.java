package org.whuims.leetcode.top100liked;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n, fast = n;
        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);
        slow = n;
        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return fast;
    }
}
