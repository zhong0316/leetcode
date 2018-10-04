package org.whuims.leetcode.stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator basicCalculator = new BasicCalculator();
        int res = basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)");
//        int res = basicCalculator.calculate("2 - (5  - 6) ");
        System.out.println(res);
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int i = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        while (i < len) {
            char c = s.charAt(i);
            if (isDigit(c)) {
                int curr = c - '0';
                while (i < len - 1 && isDigit(s.charAt(i + 1))) {
                    curr = curr * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res += curr * sign;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            } else {
                ;
            }
            i++;
        }
        return res;
    }

    private boolean isDigit(char c) {
        return c <= '9' && c >= '0';
    }
}
