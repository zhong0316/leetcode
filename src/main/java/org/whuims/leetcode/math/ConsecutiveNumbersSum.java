package org.whuims.leetcode.math;

public class ConsecutiveNumbersSum {

    public static void main(String[] args) {
        ConsecutiveNumbersSum consecutiveNumbersSum = new ConsecutiveNumbersSum();
        int res = consecutiveNumbersSum.consecutiveNumbersSum(72316829);
        System.out.println(res);
    }

    /**
     * 对于一个正整数NN，如果能写成KK个连续正整数相加的形式，则有，
     * N=(x+1)+(x+2)+…+(x+K)
     * N=(x+1)+(x+2)+…+(x+K)
     *
     * N=K∗x+(1+K)∗K2
     * N=K∗x+(1+K)∗K2
     *
     * 于是，N能够写成K个连续正整数相加的条件是，(N−K∗(K+1)2)(N−K∗(K+1)2)能够被KK整除。
     *
     * 时间复杂度分析：KK个连续正整数相加，K的取值从11开始，且满足(N−K∗(K+1)2)(N−K∗(K+1)2)大于等于0。KK的可取值范围为n‾√n量级。
     * @param N
     * @return
     */
    public int consecutiveNumbersSum(int N) {
        int res = 1;
        for (int k = 2; k * (k + 1) <= 2 * N; k++) {
            if ((N - k * (k + 1) / 2) % k == 0) {
                res++;
            }
        }
        return res;
    }
}
