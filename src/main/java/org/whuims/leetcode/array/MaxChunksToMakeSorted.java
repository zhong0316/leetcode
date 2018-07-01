package org.whuims.leetcode.array;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
        int[] arr = {1, 0, 2, 3, 4};
        int res = maxChunksToMakeSorted.maxChunksToSorted(arr);
        System.out.println(res);
    }

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int res = 0;
        int[] maxSofar = new int[n];
        maxSofar[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxSofar[i] = Math.max(maxSofar[i - 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i == maxSofar[i]) {
                res++;
            }
        }
        return res;
    }
}
