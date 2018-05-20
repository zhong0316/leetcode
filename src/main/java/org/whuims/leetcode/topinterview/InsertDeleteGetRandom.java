package org.whuims.leetcode.topinterview;

import java.util.*;

public class InsertDeleteGetRandom {

    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();
    int size = 0;
    List<Integer> list = new ArrayList<>();

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom() {

    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            if (list.size() <= size) {
                list.add(val);
            } else {
                list.set(size, val);
            }
            map.put(val, size);
            size++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            map.remove(val);
            size--;
            int end = list.get(size);
            if (list.size() > 0 && val != end) {
                map.put(end, index);
                list.set(index, end);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int index = random.nextInt(size);
        return list.get(index);
    }
}
