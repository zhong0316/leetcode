package org.whuims.leetcode.twopointers;

public class LongestMountainInArray {

    public static void main(String[] args) {
        LongestMountainInArray longestMountainInArray = new LongestMountainInArray();
        int[] A = {2, 1, 4, 7, 3, 2, 5};
        int res = longestMountainInArray.longestMountain(A);
        System.out.println(res);
    }

    public int longestMountain(int[] A) {
        if (A == null || A.length < 3) {
            return 0;
        }
        int n = A.length;
        int i = 0, j = 0;
        int res = 0, leftCounter = 0, rightCounter = 0;
        while (true) {
            if (i >= n) {
                break;
            }
            while (i < n - 1 && A[i] < A[i + 1]) {
                i++;
                leftCounter++;
            }
            while (i < n - 1 && A[i] > A[i + 1]) {
                i++;
                rightCounter++;
            }
            if (leftCounter == 0 || rightCounter == 0) {
                i++;
            } else {
                res = Math.max(res, leftCounter + rightCounter + 1);
            }
            leftCounter = 0;
            rightCounter = 0;
            i = j++;
        }
        return res;
    }
}
