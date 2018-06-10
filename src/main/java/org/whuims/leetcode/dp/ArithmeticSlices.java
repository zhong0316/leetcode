package org.whuims.leetcode.dp;

public class ArithmeticSlices {

    public static void main(String[] args) {
        ArithmeticSlices arithmeticSlices = new ArithmeticSlices();
        int[] A = new int[]{1, 2, 3, 4, 5};
        int res = arithmeticSlices.numberOfArithmeticSlices(A);
        System.out.println(res);
    }

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }
        int res = 0, cur = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur += 1;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
