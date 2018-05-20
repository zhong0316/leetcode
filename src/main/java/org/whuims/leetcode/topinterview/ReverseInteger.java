package org.whuims.leetcode.topinterview;

public class ReverseInteger {

    public static int reverse(int x) {
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        if (Math.abs(x) < 10) {
            return x;
        }
        boolean positive = x > 0;
        int abs = Math.abs(x);
        int count = String.valueOf(abs).length();
        if (positive) {
            return reversePositive(abs, count);
        } else {
            return 0 - reversePositive(abs, count);
        }
    }

    public static int reversePositive(int i, int count) {
        long result = 0L;
        while (--count >= 0) {
            result += ((i % 10) * (long) Math.pow(10, count));
            i /= 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }
}
