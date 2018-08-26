package org.whuims.leetcode.array;

import org.whuims.leetcode.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(13, 16));
//        List<Interval> intervals = Arrays.asList(new Interval(1, 5));
        List<Interval> res = new InsertInterval().insert(intervals, new Interval(4, 8));
        for (Interval re : res) {
            System.out.println("[" + re.start + "," + re.end + "]");
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int size = intervals.size();
        if (newInterval.start > intervals.get(size - 1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < size; i++) {
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start || curr.start > newInterval.end) {
                res.add(curr);
            } else {
                int min = Math.min(curr.start, newInterval.start);
                int max = Math.max(curr.end, newInterval.end);
                newInterval.start = min;
                newInterval.end = max;
            }
        }
        if (res.size() == 0) {
            res.add(newInterval);
        } else {
            if (newInterval.end < res.get(0).start) {
                res.add(0, newInterval);
            } else if (newInterval.start > res.get(res.size() - 1).end) {
                res.add(res.size(), newInterval);
            } else {
                for (int i = 0; i < res.size() - 1; i++) {
                    if (res.get(i).end < newInterval.start && res.get(i + 1).start > newInterval.end) {
                        res.add(i + 1, newInterval);
                    }
                }
            }
        }
        return res;
    }
}
