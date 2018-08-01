package org.whuims.leetcode.stack;

import java.util.LinkedList;

public class ScoreOfParentheses {

    public static void main(String[] args) {
        ScoreOfParentheses scoreOfParentheses = new ScoreOfParentheses();
        int res = scoreOfParentheses.scoreOfParentheses("(()(()))");
        System.out.println(res);
    }

    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int n = S.length();
        int res = 0;
        char[] cs = S.toCharArray();
//        int depth = 0;
//        int lastChar = ' ';
//        for (int i = 0; i < n; i++) {
//            char c = cs[i];
//            if (c == '(') {
//                depth++;
//            } else {
//                depth--;
//                if (lastChar == '(') {
//                    res += 1 << depth;
//                }
//            }
//            lastChar = c;
//        }
//        return res;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                stack.offerLast(c);
            } else {
                if (stack.peekLast() == '(') {
                    stack.pollLast();
                    stack.offerLast('1');
                } else {
                    char temp = stack.pollLast();
                    if (stack.peekLast() != '(') {
                        stack.pollLast();
                        int num = temp - '0';
                        num *= 2;
                        stack.offerLast(Character.forDigit(num, 10));
                    } else {

                    }
                }
            }
        }
        System.out.println();
        return res;
    }
}
