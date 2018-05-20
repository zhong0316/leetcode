package org.whuims.leetcode.top100liked;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return new String();
        }
        Stack<Integer> ops = new Stack<>();
        Stack<String> res = new Stack<>();
        res.push("");
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int count = c - '0';
                int temp = i + 1;
                while (s.charAt(temp) <= '9' && s.charAt(temp) >= '0') {
                    count = count * 10 + (s.charAt(temp) - '0');
                    temp++;
                    i++;
                }
                ops.push(count);
            } else if (c == '[') {
                res.push("");
            } else if (c == ']') {
                int op = ops.pop();
                String temp = res.pop();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < op; j++) {
                    sb.append(temp);
                }
                String toPush = sb.toString();
                res.push(res.pop() + toPush);
            } else {
                res.push(res.pop() + String.valueOf(c));
            }
            i++;
        }
        return res.pop();
    }
}
