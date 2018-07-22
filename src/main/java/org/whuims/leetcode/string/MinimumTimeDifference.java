package org.whuims.leetcode.string;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    public static void main(String[] args) {
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        List<String> timePoints = Arrays.asList("01:01", "02:01", "03:00");
        int res = minimumTimeDifference.findMinDifference(timePoints);
        System.out.println(res);
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String timePoint : timePoints) {
            int hour = (timePoint.charAt(0) - '0') * 10 + (timePoint.charAt(1) - '0');
            int minute = (timePoint.charAt(3) - '0') * 10 + (timePoint.charAt(4) - '0');
            if (mark[hour * 60 + minute]) return 0;
            mark[hour * 60 + minute] = true;
        }

        int min = Integer.MAX_VALUE, prev = 0;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, 24 * 60 + first - last);
        return min;
    }
}
