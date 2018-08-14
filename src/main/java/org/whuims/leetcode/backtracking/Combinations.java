package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> res = combinations.combine(4, 4);
        res.forEach(o -> {
            o.forEach(r -> System.out.print(" " + r));
            System.out.println();
        });
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0) {
            return res;
        }
        backtracking(res, new ArrayList<>(), n, k, 0);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> curr, int n, int k, int start) {
        if (start > n) {
            return;
        }
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = start; i <= n; i++) {
                curr.add(i + 1);
                backtracking(res, curr, n, k, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
