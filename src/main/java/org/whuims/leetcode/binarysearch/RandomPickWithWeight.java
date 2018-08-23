package org.whuims.leetcode.binarysearch;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {

    Random random = new Random();
    TreeMap<Integer, Integer> treeMap;
    int total;

    public RandomPickWithWeight(int[] w) {
        int len = w.length;
        for (int i = 0; i < len; i++) {
            total += w[i];
            treeMap.put(total, i);
        }
    }

    public int pickIndex() {
        int val = random.nextInt(total);
        int ceilingKey = treeMap.higherKey(val);
        return treeMap.get(ceilingKey);
    }
}
