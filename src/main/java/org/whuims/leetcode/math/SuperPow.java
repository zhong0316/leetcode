package org.whuims.leetcode.math;

public class SuperPow {

    /**
     * One knowledge: ab % k = (a%k)(b%k)%k
     * a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
     * Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
     * f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
     */
    int MOD = 1337;

    public int superPow(int a, int[] b) {
        if (b.length == 1) {
            return pow(a, b[0]);
        }

        return PowArray(a, b, b.length - 1);
    }

    public int PowArray(int a, int[] b, int endindex) {
        if (endindex < 0) return 1;

        return (pow(PowArray(a, b, endindex - 1), 10) * pow(a, b[endindex])) % MOD;
    }

    public int pow(int a, int k) {
        int res = 1;
        a %= MOD;
        for (int i = 0; i < k; i++) {
            res *= a;
            res %= MOD;
        }
        return res;
    }
}
