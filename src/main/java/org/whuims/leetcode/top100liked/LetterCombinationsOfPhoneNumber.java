package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        res.add("");
        int len = digits.length();
        backtracking(res, 0, digits);
        return res;
    }

    private void backtracking(List<String> res, int offset, String digits) {
        if (offset == digits.length()) {
            return;
        } else {
            char c = digits.charAt(offset);
            String temp = map[c - '0'];
            int len = temp.length();
            List<String> nextTurn = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                List<String> tempList = new ArrayList<>(res);
                for (String str : tempList) {
                    nextTurn.add(str + temp.charAt(i));
                }
            }
            res.clear();
            res.addAll(nextTurn);
            backtracking(res, offset + 1, digits);
        }
    }
}
