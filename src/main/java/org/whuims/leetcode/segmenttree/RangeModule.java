package org.whuims.leetcode.segmenttree;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RangeModule {
    TreeMap<Integer, Integer> treeMap;

    public RangeModule() {
        treeMap = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = treeMap.floorKey(left);
        Integer end = treeMap.floorKey(right);
        if (start == null && end == null) {
            treeMap.put(left, right);
        } else if (start != null && treeMap.get(start) >= left) {
            treeMap.put(start, Math.max(treeMap.get(end), Math.max(treeMap.get(start), right)));
        } else {
            treeMap.put(left, Math.max(treeMap.get(end), right));
        }
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = treeMap.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        treeMap.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        Integer floorKey = treeMap.floorKey(left);
        if (floorKey == null) {
            return false;
        }
        return right <= treeMap.get(floorKey);
    }

    public void removeRange(int left, int right) {
        Integer start = treeMap.floorKey(left);
        Integer end = treeMap.floorKey(right);
        if (end != null && treeMap.get(end) > right) {
            treeMap.put(right, treeMap.get(end));
        }
        if (start != null && treeMap.get(start) > left) {
            treeMap.put(start, left);
        }
        Map<Integer, Integer> subMap = treeMap.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        treeMap.keySet().removeAll(set);
    }
}
