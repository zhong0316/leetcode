package org.whuims.leetcode.binarysearch;

import java.util.TreeMap;

public class ShortestSubarrayWithSumAtLeastK {

    public static void main(String[] args) {
        ShortestSubarrayWithSumAtLeastK shortestSubarrayWithSumAtLeastK = new ShortestSubarrayWithSumAtLeastK();
        int[] A = {2, -1, 2};
        int K = 3;
        int res = shortestSubarrayWithSumAtLeastK.shortestSubarray(A, K);
        System.out.println(res);
    }

    /**
     * Using TreeMap to store prefix sum, total to record prefix sum before i,
     * each time total is greater or equal than K, then compare i+1 with minLen(take the minimum number),
     * using flooorKey(total-K) to get the prefix sum(num) which satisfy total - num >= K if num exists(which means it is null),
     * we compare the length with minLen(take the minimum number) and remove the num.
     *
     * @param A
     * @param K
     * @return
     */
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        long sum = 0;
        int res = Integer.MAX_VALUE;
        TreeMap<Long, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            sum += A[i];
            if (sum >= K) {
                res = Math.min(res, i + 1);
            }
            Long num = treeMap.floorKey(sum - K);
            while (num != null) {
                res = Math.min(i - treeMap.get(num), res);
                treeMap.remove(num);
                // 寻找下一个key不大于num且尽量大的key
                num = treeMap.lowerKey(num);
            }
            treeMap.put(sum, i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
