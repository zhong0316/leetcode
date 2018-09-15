package org.whuims.leetcode.array;

public class MaxChunksToMakeSortedII {

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int len = arr.length;
        int[] maxOfLeft = new int[len];
        int[] minOfRight = new int[len];
        maxOfLeft[0] = arr[0];
        minOfRight[len - 1] = arr[len - 1];
        for (int i = 1; i < len; i++) {
            maxOfLeft[i] = Math.max(arr[i], maxOfLeft[i - 1]);
            minOfRight[len - i - 1] = Math.min(arr[len - i - 1], minOfRight[len - i]);
        }
        // at least one chunk
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }
        return res++;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII maxChunksToMakeSortedII = new MaxChunksToMakeSortedII();
        System.out.println(maxChunksToMakeSortedII.y());
    }

    private Object y() {
        Object res = null;
        try {
            res = new OutOfMemoryError();
            return res;
        } finally {
            res = null;
        }
    }
}
