package org.whuims.leetcode.binarysearchtree;

import java.util.TreeSet;

public class ContainsDuplicateIII {

    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        int[] nums = {1, 5, 9, 1, 5, 9};
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(nums, 2, 3));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            Long floor = values.floor((long) nums[ind] + t);
            Long ceil = values.ceiling((long) nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add((long) nums[ind]);
            if (ind >= k) {
                values.remove((long) nums[ind - k]);
            }
        }

        return false;
    }
}
