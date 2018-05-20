package org.whuims.leetcode.topinterview;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE && x < 0) {
                n = Integer.MAX_VALUE;
                x = -x;
                return x * myPow(x * x, n / 2);
            } else if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                return x * myPow(x * x, n / 2);
            }
            n = -n;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
