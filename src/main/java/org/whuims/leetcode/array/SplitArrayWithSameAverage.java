package org.whuims.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayWithSameAverage {

    public static void main(String[] args) {
        int[] A = new int[]{10, 29, 13, 53, 33, 48, 76, 70, 5, 5};
        SplitArrayWithSameAverage splitArrayWithSameAverage = new SplitArrayWithSameAverage();
        System.out.println(splitArrayWithSameAverage.splitArraySameAverage(A));
    }

    public boolean splitArraySameAverage(int[] A) {
        int n = A.length;
        int maxK = n / 2;
        long sum = 0;
        for (int num : A) {
            sum += num;
        }
        Map<String, Boolean> cache = new HashMap<>();
        for (int i = 1; i <= maxK; i++) {
            if (sum * i % n != 0) {
                continue;
            }
            if (canSplitAverage(A, i, (int) (sum * i / n), 0, cache)) {
                return true;
            }
        }
        return false;
    }

    private boolean canSplitAverage(int[] A, int k, int target, int index, Map<String, Boolean> cache) {
        if (k == 0) {
            return target == 0;
        }
        String key = k + ":" + index + ":" + target;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        boolean result = false;
        for (int i = index; i < A.length; i++) {
            result = result | canSplitAverage(A, k - 1, target - A[i], i + 1, cache);
            if (result) {
                break;
            }
        }
        cache.put(key, result);
        return result;
    }
}
