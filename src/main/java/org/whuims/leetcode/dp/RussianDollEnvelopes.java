package org.whuims.leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {

    public static void main(String[] args) {
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
//        int[][] envelopes = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        int[][] envelopes = {{46,89},{50,53},{52,68},{72,45},{77,81}};
//        int[][] envelopes = {{2, 3}, {5, 4}, {6, 4}, {6, 7}};
        int res = russianDollEnvelopes.maxEnvelopes(envelopes);
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int len = envelopes.length;
        Arrays.sort(envelopes, Comparator.<int[]>comparingInt(o -> o[0]).thenComparingInt(o -> o[1]));
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
