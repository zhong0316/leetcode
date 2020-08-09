package org.whuims.leetcode2020.top100liked;

import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("[()]"));
    }

    public boolean isValid(String s) {
        if (s == null || s == "") {
            return true;
        }

        LinkedList<Character> l = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                l.push(c);
            } else {
                if (c == ')') {
                    if (l.isEmpty() || l.pop() != '(') {
                        return false;
                    }
                }
                if (c == '}') {
                    if (l.isEmpty() || l.pop() != '{') {
                        return false;
                    }
                }
                if (c == ']') {
                    if (l.isEmpty() || l.pop() != '[') {
                        return false;
                    }
                }
            }
        }

        return l.isEmpty();
    }
}