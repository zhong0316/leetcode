package org.whuims.leetcode;

import java.util.Random;

public class HugeNumberAdd {

    public static void main(String[] args) {
        HugeNumberAdd hugeNumberAdd = new HugeNumberAdd();
        Random random = new Random();
        for (int i = 0; i < 100; ) {
            String s1 = String.valueOf(random.nextLong()) + String.valueOf(random.nextLong()).substring(1);
            String s2 = String.valueOf(random.nextLong()) + String.valueOf(random.nextLong()).substring(1);
            boolean condition = true;
            try {
                Long.parseLong(s1);
                condition = false;
            } catch (Exception e) {
            }
            try {
                Long.parseLong(s2);
                condition = false;
            } catch (Exception e) {
            }
            if (!condition) {
                continue;
            }
            String res = hugeNumberAdd.hugeNumberAdd(s1, s2);
            System.out.println("Input:\"" + s1 + "\", \"" + s2 + "\"");
            System.out.println("Output:\"" + res + "\"");
            i++;
        }
    }

    public String hugeNumberAdd(String s1, String s2) {
        if (s1.charAt(0) == '+') {
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '+') {
            s2 = s2.substring(1);
        }
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            // both s1 and s2 are negative
            return "-" + addPositiveNumber(s1.substring(1), s2.substring(1));
        } else if (s1.charAt(0) == '-') {
            if (s1.length() - 1 > s2.length() || bigger(s1.substring(1), s2)) {
                // s1 is negative and s2 is positive, and the absolute value of s1 is bigger than s2's
                return "-" + bigNumSubtractSmallNum(s1.substring(1), s2);
            } else {
                // s1 is negative and s2 is positive, and the absolute value of s1 is smaller than s2's
                return bigNumSubtractSmallNum(s2, s1.substring(1));
            }
        } else if (s2.charAt(0) == '-') {
            if (s2.length() - 1 > s1.length() || bigger(s2.substring(1), s1)) {
                // s2 is negative and s1 is positive, and the absolute value of s2 is bigger than s1's
                return "-" + bigNumSubtractSmallNum(s2.substring(1), s1);
            } else {
                // s2 is negative and s1 is positive, and the absolute value of s2 is smaller than s1's
                return bigNumSubtractSmallNum(s1, s2.substring(1));
            }
        } else {
            // both s1 and s2 are positive
            return addPositiveNumber(s1, s2);
        }
    }

    // check whether number s1 is bigger than number s2
    private boolean bigger(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return true;
        } else if (s1.length() < s2.length()) {
            return false;
        } else {
            int counter = 0;
            while (counter < s1.length()) {
                if (s1.charAt(counter) > s2.charAt(counter)) {
                    return true;
                } else if (s1.charAt(counter) < s2.charAt(counter)) {
                    return false;
                } else {
                    counter++;
                }
            }
        }
        return false;
    }

    // bother s1 and s2 is positive
    private String addPositiveNumber(String s1, String s2) {
        StringBuilder stringBuilder = new StringBuilder();
        int len1 = s1.length(), len2 = s2.length();
        if (len1 < len2) {
            return addPositiveNumber(s2, s1);
        } else {
            int carry = 0;
            int i = 0;
            for (; i < len2; i++) {
                char c1 = s1.charAt(len1 - i - 1), c2 = s2.charAt(len2 - i - 1);
                char c = (char) (c1 + (c2 - '0' + carry));
                if (c > '9') {
                    c = (char) (c - 10);
                    carry = 1;
                } else {
                    carry = 0;
                }
                stringBuilder.append(c);
            }
            while (len1 - i - 1 >= 0) {
                char c1 = (char) (s1.charAt(len1 - i - 1) + carry);
                if (c1 > '9') {
                    c1 = (char) (c1 - 10);
                    carry = 1;
                } else {
                    carry = 0;
                }
                stringBuilder.append(c1);
                i++;
            }
            if (carry > 0) {
                stringBuilder.append(carry);
            }
            return stringBuilder.reverse().toString();
        }
    }

    // the number s1 is bigger than number s2, process s1 subtract s2
    private String bigNumSubtractSmallNum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < len2; i++) {
            int index1 = len1 - i - 1;
            int index2 = len2 - i - 1;
            char c1 = s1.charAt(index1), c2 = s2.charAt(index2);
            if (c1 >= c2) {
                stringBuilder.append(c1 - c2);
            } else {
                c1 = (char) (c1 + 10);
                stringBuilder.append(c1 - c2);
                s1 = borrow(s1, i);
            }
        }
        while (i < len1) {
            stringBuilder.append(s1.charAt(len1 - 1 - i++));
        }
        String res = stringBuilder.reverse().toString();
        int counter = 0;
        while (counter < res.length() && res.charAt(counter) == '0') {
            counter++;
        }
        return res.substring(counter).length() == 0 ? "0" : res.substring(counter);
    }

    // borrow from higher position
    private String borrow(String s1, int index) {
        char[] cs = s1.toCharArray();
        int len = s1.length();
        for (int i = index + 1; i < len; i++) {
            int realIndex = len - i - 1;
            if (cs[realIndex] > '0') {
                cs[realIndex] = (char) (cs[realIndex] - 1);
                break;
            } else {
                cs[realIndex] = '9';
            }
        }
        return new String(cs);
    }
}
