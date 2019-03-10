package org.whuims.leetcode.math;

import java.util.*;

/**
 * 899. Orderly Queue
 * Hard
 * A string S of lowercase letters is given.  Then, we may make any number of moves.
 * <p>
 * In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.
 * <p>
 * Return the lexicographically smallest string we could have after any number of moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "cba", K = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 * In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
 * Example 2:
 * <p>
 * Input: S = "baaca", K = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= S.length <= 1000
 * S consists of lowercase letters only.
 */
public class OrderlyQueue {

    public static void main(String[] args) {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        System.out.println(orderlyQueue.orderlyQueue("kikc", 3));
    }

    public String orderlyQueue(String S, int K) {
        if (S == null || S.length() == 0) {
            return null;
        }
        // K > 1时，可以交换任意两个char，最终达到排序目的，因此直接返回排序后的string
        if (K > 1) {
            char[] cs = S.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        } else {
            String res = S;
            for (int i = 1; i < S.length(); i++) {
                String temp = S.substring(i) + S.substring(0, i);
                if (res.compareTo(temp) > 0) res = temp;
            }
            return res;
        }
    }
}
