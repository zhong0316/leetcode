package org.whuims.leetcode.twopointers;

import java.util.LinkedList;
import java.util.Queue;

public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        boolean res = backspaceStringCompare.backspaceCompare("a##b", "b");
        System.out.println(res);
    }

    public boolean backspaceCompare(String S, String T) {
        String ss = getStr(S);
        String tt = getStr(T);
        if (ss == "" && tt == "") {
            return true;
        } else {
            return ss.equals(tt);
        }
    }

    private String getStr(String s) {
        Queue<Character> queue = new LinkedList<>();
        char[] sc = s.toCharArray();
        int len = sc.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (sc[i] != '#' && queue.isEmpty()) {
                stringBuilder.append(sc[i]);
            }
            if (sc[i] != '#' && !queue.isEmpty()) {
                queue.poll();
            }
            if (sc[i] == '#') {
                queue.offer('#');
            }
        }
        return stringBuilder.reverse().toString();
    }
}
