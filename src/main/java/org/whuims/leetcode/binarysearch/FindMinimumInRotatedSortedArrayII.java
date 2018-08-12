package org.whuims.leetcode.binarysearch;

public class FindMinimumInRotatedSortedArrayII {

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
        int[] arr = {3, 0, 1, 1, 3};
        int res = findMinimumInRotatedSortedArrayII.findMin(arr);
        System.out.println(res);
    }

    public int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > arr[hi]) {
                lo = mid + 1;
            } else if (arr[mid] < arr[hi]) {
                hi = mid;
            } else {
                hi--;
            }
        }
        return arr[lo];
    }
}
