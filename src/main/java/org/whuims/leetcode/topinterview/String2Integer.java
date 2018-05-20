package org.whuims.leetcode.topinterview;

public class String2Integer {

    public static void main(String[] args) {
        String2Integer string2Integer = new String2Integer();
        int res = string2Integer.myAtoi("  +0 123");
        System.out.println(res);
    }

    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int current = 0;
        int mul = 1;
        if (str.charAt(current) == '+') {
            current++;
        } else if (str.charAt(current) == '-') {
            current++;
            mul = -1;
        }

        StringBuffer integer = new StringBuffer();
        while (current < str.length() && Character.isDigit(str.charAt(current))) {
            integer.append(str.charAt(current++));
        }
        if (integer.toString().length() == 0) {
            return 0;
        }
        Long ret = 0L;
        for (int i = 0; i < integer.length(); i++) {
            char ch = integer.charAt(i);
            ret += (int) (ch - '0');
            if (i != integer.length() - 1) {
                ret *= 10;
            }
            if (ret > Integer.MAX_VALUE) {
                return mul == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return ret.intValue() * mul;
    }
}
