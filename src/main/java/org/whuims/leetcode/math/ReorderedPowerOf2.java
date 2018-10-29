package org.whuims.leetcode.math;

public class ReorderedPowerOf2 {

    public static void main(String[] args) {
        ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(64));
    }

    public boolean reorderedPowerOf2(int N) {
        int c = count(N);
        for (int i = 0; i <= 31; i++) {
            if (c == count(1 << i)) return true;
        }
        return false;
    }

    private int count(int n) {
        int res = 0;
        for (; n > 0; n /= 10) {
            res += Math.pow(10, n % 10);
        }
        return res;
    }
}
