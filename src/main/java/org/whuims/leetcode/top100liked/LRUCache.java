package org.whuims.leetcode.top100liked;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);
            map.put(key, val);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        if (map.size() == capacity) {
            Iterator itr = map.keySet().iterator();
            if (itr.hasNext()) {
                int temp = (Integer) itr.next();
                map.remove(temp);
            }
        }
        map.put(key, value);
    }
}
