package org.whuims.leetcode2020.top100liked;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
    Map<Integer, Integer> cache = new HashMap();

    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(3));
    }

    public int numTrees(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        if (n == 2) {
            return 2;
        }
        if (n <= 1) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += numTrees(i - 1) * numTrees(n - i);
        }

        cache.put(n, res);
        return res;
    }

}