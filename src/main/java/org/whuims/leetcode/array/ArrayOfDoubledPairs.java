package org.whuims.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayOfDoubledPairs {

    public static void main(String[] args){
        ArrayOfDoubledPairs arrayOfDoubledPairs = new ArrayOfDoubledPairs();
        int[] A = {1,2,4,8,8,4};
        System.out.println(arrayOfDoubledPairs.canReorderDoubled(A));
    }

    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : A) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < A.length; i++) {
            if (freq.get(A[i]) == 0) {
                continue;
            }
            if (freq.containsKey(A[i] * 2) && freq.get(A[i] * 2) > 0) {
                freq.put(A[i], freq.get(A[i]) - 1);
                freq.put(A[i] * 2, freq.get(A[i] * 2) - 1);
            }
            if (A[i] % 2 == 0 && freq.containsKey(A[i] / 2) && freq.get(A[i] / 2) > 0) {
                freq.put(A[i], freq.get(A[i]) - 1);
                freq.put(A[i] / 2, freq.get(A[i] / 2) - 1);
            }
        }
        for (int i : A) {
            if (freq.get(i) > 0) return false;
        }
        return true;
    }
}
