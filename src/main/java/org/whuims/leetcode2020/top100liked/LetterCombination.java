package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * backtracking
 */
public class LetterCombination {

    char[][] digitsMap = new char[][] { { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' }, { 'j', 'k', 'l' },
            { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    public static void main(String[] args) {
        LetterCombination l = new LetterCombination();
        List<String> res = l.letterCombinations("234");
        System.out.println(res.size());
    }

    public List<String> letterCombinations(String digits) {
        List<List<Character>> curr = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char[] cs = digitsMap[digits.charAt(i) - '2'];
            List<List<Character>> next = new ArrayList();
            if (curr.size() == 0) {
                for (char c : cs) {
                    List<Character> tmp = new ArrayList();
                    tmp.add(c);
                    curr.add(tmp);
                }
            } else {
                for (char c : cs) {
                    for (List<Character> lc : curr) {
                        List<Character> tmpCs = new ArrayList<>(lc);
                        tmpCs.add(c);
                        next.add(tmpCs);
                    }
                }

                curr = next;
            }
        }

        List<String> res = new ArrayList<>();
        for (List<Character> lc : curr) {
            StringBuilder sb = new StringBuilder();
            for (char c : lc) {
                sb.append(c);
            }
            res.add(sb.toString());
        }

        return res;
    }
}