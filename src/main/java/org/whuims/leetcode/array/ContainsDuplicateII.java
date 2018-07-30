package org.whuims.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println(containsDuplicateII.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                int pos = map.get(nums[i]);
                if (Math.abs(pos - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}