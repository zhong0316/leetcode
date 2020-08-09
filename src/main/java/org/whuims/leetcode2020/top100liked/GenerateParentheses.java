package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses g = new GenerateParentheses();
        List<String> res = g.generateParenthesis(3);
        System.out.println(res.size());
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        backtracking(n, 0, 0, res, "");
        return res;
    }

    private void backtracking(int n, int left, int right, List<String> res, String str) {
        if (left == n && right == n) {
            res.add(str);
            return;
        }

        if (left < n) {
            backtracking(n, left + 1, right, res, str + "(");
        }
        if (right < left) {
            backtracking(n, left, right + 1, res, str + ")");
        }
    }
}