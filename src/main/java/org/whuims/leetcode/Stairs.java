package org.whuims.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Stairs {

    public static void main(String[] args) {
        Stairs stairs = new Stairs();
        stairs.backtracking(10, 0, new ArrayList<>());
    }

    void backtracking(int n, int start, List<Integer> curr) {
        if (start > n) {
            return;
        }
        if (start == n) {
            curr.stream().forEach(o -> System.out.print(" " + o));
            System.out.println();
        }
        for (int i = 1; i <= 2; i++) {
            curr.add(i);
            backtracking(n, start + i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
