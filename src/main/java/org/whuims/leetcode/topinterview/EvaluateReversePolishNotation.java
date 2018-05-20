package org.whuims.leetcode.topinterview;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) {
            return 0;
        }
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> nums = new Stack<>();
        int res = 0;

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                if (s.equals("+")) {
                    res = num2 + num1;
                } else if (s.equals("-")) {
                    res = num2 - num1;
                } else if (s.equals("*")) {
                    res = num2 * num1;
                } else {
                    if (num1 == 0) {
                        if (num2 > 0) {
                            return Integer.MAX_VALUE;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else {
                        res = num2 / num1;
                    }
                }
                nums.push(res);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return res;
    }
}
