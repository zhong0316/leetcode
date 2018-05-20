package org.whuims.leetcode.topinterview;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        Integer[] temp = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp, (i1, i2) -> {
            Long res1 = Long.parseLong(String.valueOf(i1) + String.valueOf(i2));
            Long res2 = Long.parseLong(String.valueOf(i2) + String.valueOf(i1));
            return (int) (res2 - res1);
        });
        if (temp[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int num : temp) {
            sb.append(num);
        }
        return sb.toString();
    }
}
