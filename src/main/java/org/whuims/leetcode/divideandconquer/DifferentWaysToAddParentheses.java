package org.whuims.leetcode.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        List<Integer> res = differentWaysToAddParentheses.diffWaysToCompute("2*3-4*5");
        res.forEach(o -> System.out.println(o));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-' || c == '+' || c == '*') {
                String leftPart = input.substring(0, i);
                String rightPart = input.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(leftPart);
                List<Integer> rightRes = diffWaysToCompute(rightPart);
                for (int leftNum : leftRes) {
                    for (int rightNum : rightRes) {
                        if (c == '-') {
                            res.add(leftNum - rightNum);
                        } else if (c == '+') {
                            res.add(leftNum + rightNum);
                        } else res.add(leftNum * rightNum);
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;
    }
}
