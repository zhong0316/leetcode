package org.whuims.leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    int capacity;
    Map<Integer, Integer> values;
    Map<Integer, LinkedHashSet<Integer>> lists;
    Map<Integer, Integer> counts;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        counts = new HashMap<>();
        values = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.remove(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == min && lists.get(min).size() == 0) {
            min++;
        }
        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }
        if (values.size() >= capacity) {
            int evict = lists.get(min).iterator().next();
            values.remove(evict);
            lists.get(min).remove(evict);
        }
        counts.put(key, 1);
        values.put(key, value);
        min = 1;
        lists.get(1).add(key);
    }
}
