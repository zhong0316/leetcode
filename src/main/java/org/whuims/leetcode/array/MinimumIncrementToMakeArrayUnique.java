package org.whuims.leetcode.array;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique = new MinimumIncrementToMakeArrayUnique();
        int[] A = {1, 2, 2, 2, 0};
        System.out.println(minimumIncrementToMakeArrayUnique.minIncrementForUnique(A));
    }

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && A[i + 1] <= A[i] + 1) {
                int temp = A[i + 1];
                A[i + 1] = A[i] + 1;
                res += A[i + 1] - temp;
            }
        }
        return res;
    }
}
