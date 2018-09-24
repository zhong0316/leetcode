package org.whuims.leetcode.bitmanipulation;

public class BitwiseANDOfNumbersRange {

    /**
     * 找m和n最左公共数字，例如[26, 30]:
     * 11010
     * 11011
     * 11100
     * 11101
     * 11110
     * 公共部分是11000
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int factor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            factor <<= 1;
        }
        return m << factor;
    }
}
