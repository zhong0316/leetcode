package org.whuims.leetcode.array;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int len = citations.length, hIndex = 0;
        for (int i = 0; i < len; i++) {
            if (citations[i] >= len - i) {
                hIndex = len - i;
                return hIndex;
            }
        }
        return hIndex;
    }
}
