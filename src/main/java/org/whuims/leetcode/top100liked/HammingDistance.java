package org.whuims.leetcode.top100liked;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return bitCount(x ^ y);
    }

    private int bitCount(int a) {
        int count = 0;
        while (a > 0) {
            int tempA = a & 1;
            if (tempA == 1) {
                count++;
            }
            a = a >> 1;
        }
        return count;
    }
}
