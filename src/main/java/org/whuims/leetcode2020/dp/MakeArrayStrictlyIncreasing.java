package org.whuims.leetcode2020.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeArrayStrictlyIncreasing {

    public static void main(String[] args) {
        MakeArrayStrictlyIncreasing m = new MakeArrayStrictlyIncreasing();
        int[] arr1 = { 1, 5, 3, 6, 7 };
        int[] arr2 = { 1, 3, 4 };
        System.out.println(m.makeArrayIncreasing(arr1, arr2));
    }

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int kInf = 1000000000;
        Arrays.sort(arr2);
        Set<Integer> set = new HashSet();
        for (int a : arr2) {
            set.add(a);
        }
        int[] newArr2 = new int[set.size()];
        int c = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (i > 0 && arr2[i] == arr2[i - 1]) {
                continue;
            }
            newArr2[c++] = arr2[i];
        }
        arr2 = newArr2;
        int n = arr2.length;
        int m = arr1.length;
        // swap[i][j]: min cost to make a[0:i] valid by swap : a[i] = b[j]
        // keep[i]: min cost to make a[0:i] valid by keep a[i]
        int[][] swap = new int[m][n];
        int[] keep = new int[m];

        for (int i = 0; i < m; i++) {
            keep[i] = kInf;
        }
        // init
        keep[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                swap[i][j] = kInf;
            }
        }
        for (int j = 0; j < n; j++) {
            swap[0][j] = 1;
        }
        // transform
        for (int i = 1; i < m; i++) {
            int minSwap = kInf;
            int minKeep = kInf;
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    minSwap = Math.min(minSwap, swap[i - 1][j - 1] + 1);
                }
                if (arr1[i] > arr2[j]) {
                    minKeep = Math.min(minKeep, swap[i - 1][j]);
                }
                if (arr1[i] > arr1[i - 1]) {
                    keep[i] = keep[i - 1];
                }
                if (arr2[j] > arr1[i - 1]) {
                    swap[i][j] = keep[i - 1] + 1;
                }

                keep[i] = Math.min(keep[i], minKeep);
                swap[i][j] = Math.min(swap[i][j], minSwap);
            }
        }

        int res = kInf;
        for (int j = 0; j < n; j++) {
            res = Math.min(swap[m - 1][j], res);
        }

        res = Math.min(res, keep[m - 1]);
        return res == kInf ? -1 : res;
    }
}