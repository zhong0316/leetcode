package org.whuims.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

    /**
     * 1. If it does not belong any sequences : append.getOrDefault(num, 0) == 0, create a new sequence. It requires num + 1 and num + 2 count > 0.
     *
     * 2. Once it has sequence, move sequece to num + 1.
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>(), append = new HashMap<>();
        for (int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            if (count.get(num) == 0) continue;
            else if (append.getOrDefault(num, 0) > 0) {
                append.put(num, append.get(num) - 1);
                append.put(num + 1, append.getOrDefault(num + 1, 0) + 1);
            } else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0) {
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                append.put(num + 3, append.getOrDefault(num + 3, 0) + 1);
            } else return false;
            count.put(num, count.get(num) - 1);
        }
        return true;
    }
}
