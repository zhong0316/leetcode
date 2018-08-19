package org.whuims.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // for subarray starting at mid with size k+1, we compare element of two ends to eliminate the loser
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid + k])) {
                lo = mid + 1; // arr[mid] is the one further away from x, eliminate range[lo, mid]
            } else {
                hi = mid - 1; // arr[mid+k] is the one further away, all [mid, hi] will have similar situation, eliminate them
            }
        }
        // return subarray
        List<Integer> res = new ArrayList(k);
        for (int i = 0; i < k; i++) {
            res.add(arr[lo + i]);
        }
        return res;
    }
}
