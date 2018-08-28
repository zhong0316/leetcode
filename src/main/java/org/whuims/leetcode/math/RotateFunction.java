package org.whuims.leetcode.math;

public class RotateFunction {

    public static void main(String[] args) {
        RotateFunction rotateFunction = new RotateFunction();
        int[] A = {4, 3, 2, 6};
        int res = rotateFunction.maxRotateFunction(A);
        System.out.println(res);
    }

    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        int[] f = new int[n];
        f[0] = evaluate(A);

        long maxF = f[0];
        for (int i = 1; i < A.length; i++) {
            f[i] = f[i - 1] - sum + A[i - 1] * n;
            if (f[i] > maxF) {
                maxF = f[i];
            }
        }

        return (int) maxF;
    }

    private int evaluate(int[] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            result += i * A[i];
        }
        return result;
    }
}
