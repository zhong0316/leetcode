package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {

    public static void main(String[] args) {
        System.out.println(new AdditiveNumber().isAdditiveNumber("1023"));
    }
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        return backtracking(num, 0, new ArrayList<>());
    }

    private boolean backtracking(String num, int index, List<Long> curr) {
        if (curr.size() == 2) {
            List<Long> tempList = new ArrayList<>(curr);
            while (index < num.length()) {
                int size = tempList.size();
                long num1 = tempList.get(size - 1);
                long num2 = tempList.get(size - 2);
                long next = num1 + num2;
                String nextNum = String.valueOf(num1 + num2);
                if (index + nextNum.length() > num.length()) return false;
                String nextNumRaw = num.substring(index, index + nextNum.length());
                if (index + nextNum.length() <= num.length() &&
                        !nextNum.equals(nextNumRaw)) return false;
                tempList.add(next);
                index += nextNum.length();
            }
            if (tempList.size() <= 2) return false;
            else return true;
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= num.length() / 2; j++) {
                String tempNum = num.substring(index, index + j);
                long parsedNum = Long.parseLong(tempNum);
                if (tempNum.length() != String.valueOf(parsedNum).length()) continue;
                curr.add(parsedNum);
                if (backtracking(num, index + j, curr)) return true;
                curr.remove(curr.size() - 1);
            }
        }
        return false;
    }
}
