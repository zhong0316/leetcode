package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    public static void main(String[] args) {
        MaxPointsOnLine maxPointsOnLine = new MaxPointsOnLine();
        maxPointsOnLine.test();
    }

    public void test() {
        Point[] points = new Point[]{new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)};
        System.out.println(maxPoints(points));
    }

    //    public int maxPoints(Point[] points) {
//        if (points.length < 3) {
//            return points.length;
//        }
//        int max = 0;
//        Map<BigDecimal, Integer> map = new HashMap<>();
//        for (int i = 0; i < points.length; i++) {
//            map.clear();
//            int duplicate = 1;
//            for (int j = 0; j < points.length; j++) {
//                if (i == j) {
//                    continue;
//                }
//                BigDecimal slope;
//                if (points[i].x == points[j].x && points[i].y == points[j].y) {
//                    duplicate++;
//                    continue;
//                } else {
//                    slope = getSlope(points[i], points[j]);
//                }
//                map.put(slope, map.containsKey(slope) ? map.get(slope) + 1 : 1);
//            }
//            if (map.keySet().size() == 0) {
//                max = duplicate > max ? duplicate : max;
//            } else {
//                for (BigDecimal key : map.keySet()) {
//                    max = Math.max((duplicate + map.get(key)), max);
//                }
//            }
//        }
//        return max;
//    }
//
//    private BigDecimal getSlope(Point a, Point b) {
//        if (b.x == a.x) {
//            return BigDecimal.valueOf(Integer.MAX_VALUE);
//        }
//        return BigDecimal.valueOf(b.y - a.y).divide(BigDecimal.valueOf(b.x - a.x), new MathContext(20));
//    }
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    Map<Integer, Integer> m = new HashMap<>();
                    m.put(y, 1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return generateGCD(b, a % b);
        }
    }

    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
