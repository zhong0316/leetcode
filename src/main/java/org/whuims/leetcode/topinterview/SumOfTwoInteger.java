package org.whuims.leetcode.topinterview;

public class SumOfTwoInteger {

    public int getSum(int a, int b) {
        int result = 0;
        while ((a ^ b) != a) {
            int tempA = a ^ b;
            int tempB = (a & b) << 1;
            result = tempA ^ tempB;
            a = tempA;
            b = tempB;
        }
        return result;
    }
}
