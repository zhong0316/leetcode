package org.whuims.leetcode.top100liked;

public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int k = getBit(i);
            result[i] = k;
        }
        return result;
    }

    public int getBit(int n) {
        int counter = 0;
        int k = 0;
        while (Math.pow(2, k) <= n) {
            k++;
        }
        for (int i = 0; i < k; i++) {
            int c = n & 1;
            counter += c;
            n = n >> 1;
        }
        return counter;
    }
}
