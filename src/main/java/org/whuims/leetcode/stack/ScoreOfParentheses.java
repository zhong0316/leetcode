package org.whuims.leetcode.stack;

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
        int depth = 0;
        int lastChar = ' ';
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                depth++;
            } else {
                depth--;
                if (lastChar == '(') {
                    res += 1 << depth;
                }
            }
            lastChar = c;
        }
        return res;
    }
}
