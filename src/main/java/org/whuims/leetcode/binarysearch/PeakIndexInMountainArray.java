package org.whuims.leetcode.binarysearch;

public class PeakIndexInMountainArray {

    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int[] A = {0, 1, 2, 1};
        int res = peakIndexInMountainArray.peakIndexInMountainArray(A);
        System.out.println(res);
    }

    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int len = A.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (isPeak(A, mid)) {
                return mid;
            } else if (mid < len - 1 && A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private boolean isPeak(int[] A, int index) {
        if (index == 0 || index == A.length - 1) {
            return false;
        }
        return A[index] > A[index - 1] && A[index] > A[index + 1];
    }
}
