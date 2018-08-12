package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

    public static void main(String[] args) {
        MajorityElementII majorityElementII = new MajorityElementII();
        int[] nums = {3, 2, 3};
        List<Integer> res = majorityElementII.majorityElement(nums);
        res.forEach(System.out::println);
    }

    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int len = nums.length, limit = (len / 3) + 1;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) >= limit && !res.contains(num)) {
                res.add(num);
            }
        }
        return res;
    }
}
