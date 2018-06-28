package org.whuims.leetcode.dp;

import java.util.HashMap;

public class New21Game {

    public static void main(String[] args) {
        New21Game new21Game = new New21Game();
        double res = new21Game.new21Game(21, 17, 10);
        System.out.println(res);
    }
    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 0;
        }
        return helper(N, K, W, 0, 1.0 / W, new HashMap<>());
    }

    private double helper(int N, int K, int W, int total, double factor, HashMap<String, Double> cache) {
        String key = N + "_" + K + "_" + W + "_" + total;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (K == 0) {
            if (total <= N) {
                cache.put(key, 1.0);
                return 1.0d;
            } else {
                cache.put(key, 0.0);
                return 0.0d;
            }
        }
        double res = 0d;
        for (int i = 1; i <= W; i++) {
            res += factor * helper(N, K - 1, W, total + i, factor, cache);
        }
        cache.put(key, res);
        return res;
    }
}
