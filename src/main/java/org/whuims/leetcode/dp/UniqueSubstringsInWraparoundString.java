package org.whuims.leetcode.dp;

import java.util.Arrays;

public class UniqueSubstringsInWraparoundString {

    public static void main(String[] args) {
        UniqueSubstringsInWraparoundString uniqueSubstringsInWraparoundString = new UniqueSubstringsInWraparoundString();
        System.out.println(uniqueSubstringsInWraparoundString.findSubstringInWraproundString("zab"));
    }

    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int n = p.length();
        int[] count = new int[26];
        int maxCurr = 0;
        char[] pc = p.toCharArray();
        for (int i = 0; i < n; i++) {
            if (i > 0 && (pc[i] - pc[i - 1] == 1 || pc[i] - pc[i - 1] == -25)) {
                maxCurr++;
            } else {
                maxCurr = 1;
            }
            int index = pc[i] - 'a';
            count[index] = Math.max(count[index], maxCurr);
        }
        return Arrays.stream(count).sum();
    }
}
