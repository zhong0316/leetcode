package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, (o1, o2) -> {
            if (o1.start != o2.start) {
                return o1.start - o2.start;
            } else {
                return o1.end - o2.end;
            }
        });
        while (!noOverlapping(intervals)) {
            List<Interval> next = new ArrayList<>();
            int i = 0;
            while (i < intervals.size()) {
                Interval cur = intervals.get(i);
                if (i == intervals.size() - 1) {
                    next.add(cur);
                    i++;
                    continue;
                }
                Interval nextOne = intervals.get(i + 1);
                if (cur.end >= nextOne.start) {
                    next.add(new Interval(cur.start, nextOne.end >= cur.end ? nextOne.end : cur.end));
                    i += 2;
                } else {
                    next.add(cur);
                    i++;
                }
            }
            intervals = next;
        }
        return intervals;
    }

    private boolean noOverlapping(List<Interval> intervals) {
        int size = intervals.size();
        for (int i = 0; i < size; i++) {
            Interval out = intervals.get(i);
            for (int j = i + 1; j < size; j++) {
                Interval in = intervals.get(j);
                if (out.end >= in.start) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}