package org.whuims.leetcode.topinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersactionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        if (nums1 == null || nums1.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> fre1 = new HashMap<>();
        Map<Integer, Integer> fre2 = new HashMap<>();
        for (Integer num : nums1) {
            if (fre1.containsKey(num)) {
                fre1.put(num, fre1.get(num) + 1);
            } else {
                fre1.put(num, 1);
            }
        }
        for (Integer num : nums2) {
            if (fre2.containsKey(num)) {
                fre2.put(num, fre2.get(num) + 1);
            } else {
                fre2.put(num, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer num : nums1) {
            if (fre2.containsKey(num) && fre2.get(num) > 0) {
                res.add(num);
                fre2.put(num, fre2.get(num) - 1);
            }
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }
}
