package org.whuims.leetcode.array;

import org.whuims.leetcode.binarysearch.ValidPerfectSquare;

public class ValidMountainArray {

    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        int[] A = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(validMountainArray.validMountainArray(A));
    }

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int n = A.length;
        int i = 0;
        while (i < n - 1 && A[i] < A[i + 1]) i++;
        if (i == n - 1 || i == 0) {
            return false;
        }
        while (i < n - 1 && A[i] > A[i + 1]) i++;
        return i == n - 1;
    }
}
