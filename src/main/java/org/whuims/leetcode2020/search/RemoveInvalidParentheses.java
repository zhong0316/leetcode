package org.whuims.leetcode2020.search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        RemoveInvalidParentheses r = new RemoveInvalidParentheses();
        List<String> res = r.removeInvalidParentheses("()((((((()l(");
        System.out.println(res.size());
    }

    Map<String, Boolean> cache = new HashMap<>();

    public List<String> removeInvalidParentheses(String s) {
        Set<String> r = new HashSet<>();
        if (s == null || s.equals("") || s.length() == 0) {
            return Arrays.asList("");
        }
        int n = s.length();
        Set<String> curr = new HashSet<>();
        curr.add(s);
        while (!curr.isEmpty()) {
            Set<String> next = new HashSet<>();
            for (String str : curr) {
                boolean find = false;
                List<String> tmp = bfs(str);
                if (tmp.size() > 0) {
                    r.addAll(tmp);
                    find = true;
                } else {
                    if (!find) {
                        for (int k = 0; k < str.length(); k++) {
                            if (str.charAt(k) != '(' && str.charAt(k) != ')') {
                                continue;
                            }
                            if (k == 0) {
                                next.add(str.substring(k + 1));
                            } else if (k == n - 1) {
                                next.add(str.substring(0, str.length() - 1));
                            } else {
                                String tmpStr = str.substring(0, k) + str.substring(k + 1);
                                next.add(tmpStr);
                            }
                        }
                    }
                }
            }

            if (r.size() > 0) {
                List<String> res = new ArrayList();
                for (String str : r)
                    res.add(str);
                return res;
            }

            curr = next;
        }

        return new ArrayList<>();
    }

    public List<String> bfs(String s) {
        Set<String> set = new HashSet<>();
        if (isValidParentheses(s)) {
            set.add(s);
        } else {
            int n = s.length();
            for (int i = 0; i < n; i++) {
                if (i == 0 && isValidParenthesesCache(s.substring(i + 1))) {
                    set.add(s.substring(i + 1));
                } else if (i == n - 1 && isValidParenthesesCache(s.substring(0, s.length() - 1))) {
                    set.add(s.substring(0, s.length() - 1));
                } else {
                    String tmp = s.substring(0, i) + s.substring(i + 1);
                    if (isValidParenthesesCache(tmp)) {
                        set.add(tmp);
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (String str : set)
            res.add(str);

        return res;
    }

    private boolean isValidParenthesesCache(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        boolean res = isValidParentheses(s);
        cache.put(s, res);
        return res;
    }

    private boolean isValidParentheses(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                continue;
            }

            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}