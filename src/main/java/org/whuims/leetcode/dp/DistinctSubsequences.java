package org.whuims.leetcode.dp;

public class DistinctSubsequences {

    /**
     * Ø r a b b b i t
     * Ø 1 1 1 1 1 1 1 1
     * r 0 1 1 1 1 1 1 1
     * a 0 0 1 1 1 1 1 1
     * b 0 0 0 1 2 3 3 3
     * b 0 0 0 0 1 3 3 3
     * i 0 0 0 0 0 0 3 3
     * t 0 0 0 0 0 0 0 3
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        // array creation
        int[][] mem = new int[t.length() + 1][s.length() + 1];

        // filling the first row: with 1s
        for (int j = 0; j <= s.length(); j++) {
            mem[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (t.charAt(i) == s.charAt(j)) {
                    mem[i + 1][j + 1] = mem[i][j] + mem[i + 1][j];
                } else {
                    mem[i + 1][j + 1] = mem[i + 1][j];
                }
            }
        }

        return mem[t.length()][s.length()];

    }
}
