package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public static void main(String[] args) {
        SplitArrayIntoFibonacciSequence splitArrayIntoFibonacciSequence = new SplitArrayIntoFibonacciSequence();
        List<Integer> res = splitArrayIntoFibonacciSequence.splitIntoFibonacci("17522");
        res.forEach(System.out::println);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() < 3) return res;
        backtracking(S, 0, new ArrayList<>(), res);
        return res;
    }

    private boolean backtracking(String S, int index, List<Long> curr, List<Integer> res) {
        if (index > S.length()) return false;
        if (curr.size() == 2) {
            List<Long> tempList = new ArrayList<>(curr);
            while (index < S.length()) {
                int size = tempList.size();
                long num1 = tempList.get(size - 1);
                long num2 = tempList.get(size - 2);
                long next = num1 + num2;
                if (next > Integer.MAX_VALUE) return false;
                String nextNum = String.valueOf(num1 + num2);
                if (index + nextNum.length() > S.length()) return false;
                String nextNumRaw = S.substring(index, index + nextNum.length());
                if (index + nextNum.length() <= S.length() &&
                        !nextNum.equals(nextNumRaw)) return false;
                tempList.add(next);
                index += nextNum.length();
            }
            if (tempList.size() > 2) {
                for (Long num : tempList) res.add(num.intValue());
                return true;
            } else return false;
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= S.length() / 3 + 1; j++) {
                    String deltaStr = S.substring(index, index + j);
                    if (deltaStr.length() > String.valueOf(Integer.MAX_VALUE).length()) continue;
                    Long deltaNum = Long.parseLong(deltaStr);
                    if (deltaNum > Integer.MAX_VALUE) continue;
                    if (deltaStr.length() != String.valueOf(deltaNum).length()) continue;
                    curr.add(deltaNum);
                    if (backtracking(S, index + j, curr, res)) return true;
                    curr.remove(curr.size() - 1);
                }
            }
        }
        return false;
    }
}
