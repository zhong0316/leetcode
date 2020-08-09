package org.whuims.leetcode2020.dp;

import java.util.HashSet;
import java.util.Set;

public class BitwiseOrsOfSubarrays {

    public static void main(String[] args) {
        BitwiseOrsOfSubarrays b = new BitwiseOrsOfSubarrays();
        System.out.println(b.subarrayBitwiseORs(new int[] { 3, 11 }));
    }

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> curr = new HashSet<>();
        Set<Integer> next = null;
        Set<Integer> res = new HashSet<>();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            next = new HashSet<>();
            next.add(A[i]);
            for (int temp : curr) {
                next.add(temp | A[i]);
            }
            curr = next;
            res.addAll(next);
        }

        return res.size();
    }
}