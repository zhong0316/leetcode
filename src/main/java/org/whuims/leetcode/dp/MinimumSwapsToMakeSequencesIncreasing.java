package org.whuims.leetcode.dp;

public class MinimumSwapsToMakeSequencesIncreasing {

    public int minSwap(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[1000];
        int[] notSwap = new int[1000];
        swap[0] = 1;
        for (int i = 1; i < N; ++i) {
            notSwap[i] = swap[i] = N;
            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                notSwap[i] = notSwap[i - 1];
                swap[i] = swap[i - 1] + 1;
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                notSwap[i] = Math.min(notSwap[i], swap[i - 1]);
                swap[i] = Math.min(swap[i], notSwap[i - 1] + 1);
            }
        }
        return Math.min(swap[N - 1], notSwap[N - 1]);
    }
}
