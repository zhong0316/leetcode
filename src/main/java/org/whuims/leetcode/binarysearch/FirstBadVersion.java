package org.whuims.leetcode.binarysearch;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean isBad = isBadVersion(mid);
            if (isBad) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
