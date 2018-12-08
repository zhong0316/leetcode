package org.whuims.leetcode.greedy;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        BagOfTokens bagOfTokens = new BagOfTokens();
        int[] tokens = {100};
        System.out.println(bagOfTokens.bagOfTokensScore(tokens, 50));
    }

    public int bagOfTokensScore(int[] tokens, int P) {
        int res = 0, curr = 0;
        int n = tokens.length;
        int left = 0, right = n - 1;
        Arrays.sort(tokens);
        while (left <= right) {
            if (P >= tokens[left]) {
                curr++;
                res = Math.max(res, curr);
                P -= tokens[left];
                left++;
            } else if (curr >= 1) {
                P += tokens[right];
                right--;
                curr--;
            } else {
                break;
            }
        }
        return res;
    }
}
