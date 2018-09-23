package org.whuims.leetcode.stack;

import java.util.*;

public class SimplifyPath {

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        String[] arr = path.split("/");
        Set<String> ignore = new HashSet<>(Arrays.asList(".", "..", ""));
        Deque<String> stack = new LinkedList<>();
        for (String str : arr) {
            if (!ignore.contains(str)) {
                stack.push(str);
            }
            if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        String res = "";
        for (String str : stack) {
            res = "/" + str + res;
        }
        return res.isEmpty() ? "/" : res;
    }

}
