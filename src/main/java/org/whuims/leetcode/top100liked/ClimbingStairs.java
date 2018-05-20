package org.whuims.leetcode.top100liked;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return f(n);
    }

    private int f(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = 0;
        if (n <= 1) {
            result = 1;
        } else {
            result = f(n - 1) + f(n - 2);
        }
        cache.put(n, result);
        return result;
    }
}
