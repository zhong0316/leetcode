package org.whuims.leetcode.math;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.binaryGap(9));
    }

    public int binaryGap(int N) {
        int res = 0;
        int prev = -1;
        int i = 0;
        while (N != 0) {
            if ((N & 1) != 0) {
                if (prev != -1) {
                    res = Math.max(res, i - prev);
                }
                prev = i;
            }
            i++;
            N >>= 1;
        }
        return res;
    }
}
