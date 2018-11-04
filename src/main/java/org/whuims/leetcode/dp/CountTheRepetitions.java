package org.whuims.leetcode.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTheRepetitions {

    public static void main(String[] args) {
        CountTheRepetitions countTheRepetitions = new CountTheRepetitions();
        long start = System.currentTimeMillis();
        System.out.println(countTheRepetitions.getMaxRepetitions("aahumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxf", 1000000,
                "aac",
                1000000));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || n1 == 0 || n2 == 0) return 0;
        int i = 0, j = 0, len1 = s1.length(), len2 = s2.length();
        int counter1 = 0, counter2 = 0;
        char[] charArr1 = s1.toCharArray(), charArr2 = s2.toCharArray();
        while (counter1 < n1) {
            if (charArr1[i] == charArr2[j]) {
                j++;
                if (j == len2) {
                    j = 0;
                    counter2++;
                }
            }
            i++;
            if (i == len1) {
                i = 0;
                counter1++;
            }
        }
        return counter2 / n2;
    }
}
