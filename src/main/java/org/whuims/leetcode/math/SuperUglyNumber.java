package org.whuims.leetcode.math;

import java.util.Arrays;

public class SuperUglyNumber {

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        int res = superUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
        System.out.println(res);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] pointer = new int[primes.length];
        Arrays.fill(pointer, 0);
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < primes.length; j++) {
                if (ugly[pointer[j]] * primes[j] < min) {
                    min = ugly[pointer[j]] * primes[j];
                    minIndex = j;
                } else if (ugly[pointer[j]] * primes[j] == min) {
                    pointer[j]++;
                }
            }
            pointer[minIndex]++;
            ugly[i] = min;
        }
        return ugly[n - 1];
    }
}
