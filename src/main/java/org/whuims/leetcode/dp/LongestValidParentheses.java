package org.whuims.leetcode.dp;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        int res = longestValidParentheses.longestValidParentheses("()((())()");
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        int count = 0;
        int start = 0, end = start + 1;
        while (true) {
            if (start > s.length() || end > s.length()) {
                break;
            }
            int temp = start;
            while (temp < s.length() && s.charAt(temp) == ')') {
                temp++;
            }
            end = temp;
            count = 1;
            int lastValidIndex = 0;
            boolean find = false;
            while (count >= 0 && end < s.length()) {
                end++;
                if (end >= s.length()) {
                    break;
                }
                char c = s.charAt(end);
                if (c == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count == 0) {
                    lastValidIndex = end;
                    find = true;
                }
            }
            max = Math.max(max, lastValidIndex - temp + 1);
            if (find) {
                start = lastValidIndex + 1;
            } else {
                start++;
            }
        }
        return max;
    }
}
