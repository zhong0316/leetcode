package org.whuims.leetcode.twopointers;

import java.util.Arrays;

public class UniqueLetterString {

    public static void main(String[] args) {
        UniqueLetterString uniqueLetterString = new UniqueLetterString();
        int res = uniqueLetterString.uniqueLetterString("ABA");
        System.out.println(res);
        System.out.println("commit 3");
        System.out.println("commit 1");
    }
    public int uniqueLetterString(String s) {
        if (s == null || s.length() <= 1) {
            return s.length();
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        int[][] lastTwoPosition = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(lastTwoPosition[i], -1);
        }
        int res = 0;
        double mod = 1E9 + 7;

        for (int i = 0; i < n; i++) {
            char c = chars[i];
            int[] pos = lastTwoPosition[c - 'A'];
            res = (int) ((res + ((i - pos[1]) * (pos[1] - pos[0])) % mod) % mod);
            lastTwoPosition[c - 'A'] = new int[]{pos[1], i};
        }
        for (int i = 0; i < 26; i++) {
            int[] pos = lastTwoPosition[i];
            res = (int) ((res + (n - pos[1]) * (pos[1] - pos[0]) % mod) % mod);
        }
        return res;
    }
}
