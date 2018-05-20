package org.whuims.leetcode.top100liked;

import java.util.*;

public class RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> visit = new HashSet<>();
        List<String> res = new ArrayList<>();
        boolean find = false;
        while (queue.size() > 0) {
            String str = queue.poll();
            if (validParentheses(str)) {
                res.add(str);
                visit.add(str);
                find = true;
            }
            if (!find) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c != '(' && c != ')') {
                        continue;
                    }
                    String temp = str.substring(0, i) + str.substring(i + 1);
                    if (!visit.contains(temp)) {
                        queue.offer(temp);
                        visit.add(temp);
                    }
                }
            }
        }
        if (res.size() > 0) {
            return res;
        } else {
            res.add("");
            return res;
        }
    }

    private boolean validParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                continue;
            }
            if (c == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
