package org.whuims.leetcode.binarysearch;

import org.whuims.leetcode.Interval;

import java.util.Arrays;
import java.util.TreeMap;

public class FindRightInterval {

    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        Interval[] intervals = new Interval[]{new Interval(1, 4), new Interval(2, 3), new Interval(3, 4)};
        int[] res = findRightInterval.findRightInterval(intervals);
        for (int e : res) {
            System.out.println(e);
        }
    }

    /**
     * max votes answer, beats 30%
     *
     * @param intervals
     * @return
     */
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) map.put(intervals[i].start, i);
        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }

    /**
     * 1.IndexedInterval继承Interval，记录原始的位置。
     * 2.对转换后的IndexedInterval排序。
     * 3.二分查找每一个Interval
     *
     * @param intervals
     * @return
     */
    public int[] findRightIntervalMine(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        if (intervals.length == 1) {
            return new int[]{-1};
        }
        int len = intervals.length;
        IndexedInterval[] indexedIntervals = new IndexedInterval[len];
        for (int i = 0; i < len; i++) {
            indexedIntervals[i] = new IndexedInterval(i);
            indexedIntervals[i].start = intervals[i].start;
            indexedIntervals[i].end = intervals[i].end;
        }
        Arrays.sort(indexedIntervals, (o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int index = indexedIntervals[i].index;
            res[index] = binarySearch(indexedIntervals, i, i + 1, len - 1);
        }
        return res;
    }

    private int binarySearch(IndexedInterval[] intervals, int i, int start, int end) {
        if (start < 0 || end >= intervals.length || start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            IndexedInterval midInterval = intervals[mid];
            if (midInterval.start >= intervals[i].end) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start < intervals.length && intervals[start].start >= intervals[i].end) {
            return intervals[start].index;
        }
        return -1;
    }

    class IndexedInterval extends Interval {
        public int index;

        public IndexedInterval(int index) {
            super();
            this.index = index;
        }
    }
}
