package org.whuims.leetcode.twopointers;

public class BinarySubarraysWithSum {

    public static void main(String[] args) {
        BinarySubarraysWithSum binarySubarraysWithSum = new BinarySubarraysWithSum();
        int[] A = {1, 0, 1, 0, 1};
        int S = 2;
        System.out.println(binarySubarraysWithSum.numSubarraysWithSum(A, S));
    }

    public int numSubarraysWithSum(int[] A, int S) {
        int len = A.length;
        int res = 0, prevSum = 0;
        int[] count = new int[len + 1];
        count[0] = 1;
        for (int num : A) {
            prevSum += num;
            if (prevSum >= S) {
                res += count[prevSum - S];
            }
            count[prevSum]++;
        }
        return res;
    }
}
