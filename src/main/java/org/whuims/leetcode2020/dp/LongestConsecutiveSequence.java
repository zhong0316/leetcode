package org.whuims.leetcode2020.dp;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        int[] nums = { 100, 4, 200, 1, 3, 2, 5, 201 };
        System.out.println(l.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i] - 1)) {
                int left = nums[i];
                int right = nums[i] + 1;
                while (set.contains(right))
                    right++;
                res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }
}