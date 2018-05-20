package org.whuims.leetcode.top100liked;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int j = 0, k = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left) && i != map.get(left)) {
                j = i;
                k = map.get(left);
                break;
            }
        }
        int[] ret = new int[2];
        ret[0] = j;
        ret[1] = k;
        return ret;
    }

}
