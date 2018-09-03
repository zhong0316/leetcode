package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, List<Integer>> position = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            List<Integer> positions = position.getOrDefault(num, new ArrayList<>());
            positions.add(i);
            position.put(num, positions);
        }
        int maxFreq = 0;
        for (int i = 0; i < len; i++) {
            maxFreq = Math.max(maxFreq, position.get(nums[i]).size());
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (position.get(nums[i]).size() == maxFreq) {
                List<Integer> positions = position.get(nums[i]);
                res = Math.min(positions.get(positions.size() - 1) - positions.get(0) + 1, res);
            }
        }
        return res;
    }
}
