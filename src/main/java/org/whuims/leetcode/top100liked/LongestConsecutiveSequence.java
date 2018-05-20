package org.whuims.leetcode.top100liked;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> res = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (!res.containsKey(num)) {
                int left = res.getOrDefault(num - 1, 0);
                int right = res.getOrDefault(num + 1, 0);
                int len = right + left + 1;
                res.put(num, len);
                max = Math.max(max, len);
                res.put(num - left, len);
                res.put(num + right, len);
            } else {
                ;
            }
        }
        return max;
    }

}
