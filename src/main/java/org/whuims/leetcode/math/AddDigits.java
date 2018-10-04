package org.whuims.leetcode.math;

public class AddDigits {

    /**
     * The problem, widely known as digit root problem, has a congruence formula:
     *
     * https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
     * For base b (decimal case b = 10), the digit root of an integer is:
     *
     * dr(n) = 0 if n == 0
     * dr(n) = (b-1) if n != 0 and n % (b-1) == 0
     * dr(n) = n mod (b-1) if n % (b-1) != 0
     * or
     *
     * dr(n) = 1 + (n - 1) % 9
     * @param num
     * @return
     */
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
