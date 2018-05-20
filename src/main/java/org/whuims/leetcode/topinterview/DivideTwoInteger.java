package org.whuims.leetcode.topinterview;

public class DivideTwoInteger {

    public static void main(String[] args) {
        int res = new DivideTwoInteger().divide(Integer.MIN_VALUE, -1);
        System.out.println(res);
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        if (dividend < 0) {
            if (divisor < 0) {
                return divisor < dividend ? 0 : 1 + divide(-(dividend - divisor), -divisor);
            } else {
                return -divisor < dividend ? 0 : -(1 + divide(-(dividend + divisor), divisor));
            }
        }
        if (divisor < 0) {
            return -divide(dividend, -divisor);
        }
        // two positives
        if (dividend < divisor) {
            return 0;
        }
        int num = divisor;
        int res = 1;
        while (num <= Integer.MAX_VALUE >> 1 && num << 1 < dividend) {
            num <<= 1;
            res <<= 1;
        }
        return res + divide(dividend - num, divisor);
    }
}
