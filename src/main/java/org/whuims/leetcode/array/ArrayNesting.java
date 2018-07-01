package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayNesting {

    public static void main(String[] args) {
        ArrayNesting arrayNesting = new ArrayNesting();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        int res = arrayNesting.arrayNesting(nums);
        System.out.println(res);
    }

    public int arrayNesting(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // key: currVal, val: nestingArray Length
        Map<Integer, Integer> cache = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, nestingLen(nums, i, cache));
        }
        return res;
    }

    private int nestingLen(int[] nums, int startIndex, Map<Integer, Integer> cache) {
        int startVal = nums[startIndex];
        if (cache.containsKey(startVal)) {
            return cache.get(startVal);
        }
        List<Integer> list = new ArrayList<>();
        list.add(startVal);
        int curr = startVal;
        int counter = 0;
        while (nums[curr] != startVal) {
            counter++;
            list.add(curr);
            curr = nums[curr];
        }
        int res = counter + 1;
        for (int i : list) {
            cache.put(i, res);
        }
        return res;
    }
}
