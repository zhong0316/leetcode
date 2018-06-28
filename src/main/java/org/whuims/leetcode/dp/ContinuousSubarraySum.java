package org.whuims.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public static void main(String[] args) {
        ContinuousSubarraySum continuousSubarraySum = new ContinuousSubarraySum();
        int[] nums = {0,0};
        System.out.println(continuousSubarraySum.checkSubarraySum(nums, 0));
    }

//    public boolean checkSubarraySum(int[] nums, int k) {
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
//            put(0, -1);
//        }};
//        int runningSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            runningSum += nums[i];
//            if (k != 0) {
//                runningSum %= k;
//            }
//            Integer prev = map.get(runningSum);
//            if (prev != null) {
//                if (i - prev > 1) {
//                    return true;
//                }
//            } else {
//                map.put(runningSum, i);
//            }
//        }
//        return false;
//    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(-1, 0);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.put(i, sum);
        }
        for (int i = -1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (k == 0 && (sumMap.get(j) - sumMap.get(i) == 0) && j - i > 1) {
                    return true;
                }
                if (k != 0 && (sumMap.get(j) - sumMap.get(i)) % k == 0 && j - i > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
