package org.whuims.leetcode.binarysearch;

public class HIndexII {

    public static void main(String[] args) {
        HIndexII hIndexII = new HIndexII();
        int[] citations = {0, 1};
        int res = hIndexII.hIndex(citations);
        System.out.println(res);
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int left = 0, right = n - 1, mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] > n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - (right + 1);
    }
}
