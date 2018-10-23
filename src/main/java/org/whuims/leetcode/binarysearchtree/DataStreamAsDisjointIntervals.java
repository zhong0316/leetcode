package org.whuims.leetcode.binarysearchtree;

import org.whuims.leetcode.Interval;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataStreamAsDisjointIntervals {

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals dataStreamAsDisjointIntervals = new DataStreamAsDisjointIntervals();
        dataStreamAsDisjointIntervals.addNum(6);
        dataStreamAsDisjointIntervals.addNum(6);
        dataStreamAsDisjointIntervals.addNum(0);
        List<Interval> res = dataStreamAsDisjointIntervals.getIntervals();
        res.forEach(System.out::println);
    }

    TreeSet<Interval> treeSet;

    /**
     * Initialize your data structure here.
     */
    TreeMap<Integer, Interval> tree;

    public DataStreamAsDisjointIntervals() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(tree.values());
    }
}
