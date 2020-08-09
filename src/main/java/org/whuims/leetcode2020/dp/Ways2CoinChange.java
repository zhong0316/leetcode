package org.whuims.leetcode2020.dp;

import java.util.Map;
import java.util.HashMap;

public class Ways2CoinChange {
    
    Map<Integer, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        Ways2CoinChange w = new Ways2CoinChange();
        System.out.println(w.waysToChange(10));
    }

    public int waysToChange(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int res = waysToChange(n - 1);
        if (n >= 5) {
            res += waysToChange(n - 5);
        }
        if (n >= 10) {
            res += waysToChange(n - 10);
        }

        if (n >= 25) {
            res += waysToChange(n - 25);
        }
        memo.put(n, res);
        return res;
    }
}