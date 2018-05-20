package org.whuims.leetcode.top100liked;

import java.util.ArrayDeque;

public class ValidParentheses {

    public boolean isValid(String s) {
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    arrayDeque.add(ch);
                    break;
                case '{':
                    arrayDeque.add(ch);
                    break;
                case '[':
                    arrayDeque.add(ch);
                    break;
                case ')':
                    if (arrayDeque.size() > 0 && arrayDeque.getLast() == '(') {
                        arrayDeque.removeLast();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (arrayDeque.size() > 0 && arrayDeque.getLast() == '{') {
                        arrayDeque.removeLast();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (arrayDeque.size() > 0 && arrayDeque.getLast() == '[') {
                        arrayDeque.removeLast();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return arrayDeque.size() == 0;
    }
}
