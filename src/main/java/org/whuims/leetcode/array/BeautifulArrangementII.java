package org.whuims.leetcode.array;

import java.util.Arrays;

public class BeautifulArrangementII {

    public static void main(String[] args) {
        BeautifulArrangementII beautifulArrangementII = new BeautifulArrangementII();
        int[] res = beautifulArrangementII.constructArray(3, 2);
        Arrays.stream(res).forEach(o -> System.out.print(" " + o));
        System.out.println();
    }

    /**
     * 1,n,2,n-1,3,n-2,4... ==> Diff: n-1, n-2, n-3, n-4, n-5...
     * By following this pattern, k numbers will have k-1 distinct difference values;
     * and all the rest numbers should have |ai - a_i-1| = 1;
     * In total, we will have k-1+1 = k distinct values.
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        if (k >= n) {
            return null;
        }
        int[] arr = new int[n];
        int i = 0, small = 1, large = n;
        while (i < k) {
            arr[i++] = small++;
            if (i < k) {
                arr[i++] = large--;
            }
        }
        if (k % 2 == 0) {
            // k==2 ==> 1, 6, 5,4,3,2
            while (i < arr.length) {
                arr[i++] = large--;
            }
        } else {
            // k==3 ==> 1,6,2,3,4,5
            while (i < arr.length) {
                arr[i++] = small++;
            }
        }
        return arr;
    }
}
