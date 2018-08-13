package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        int[] candidates = {14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        int target = 27;
        List<List<Integer>> res = combinationSumII.combinationSum2(candidates, target);
        res.forEach(o -> {
            o.forEach(r -> System.out.print(" " + r));
            System.out.println();
        });
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> curr, int[] candidates, int start, int currSum, int target) {
        if (start > candidates.length || currSum > target) {
            return;
        }
        if (currSum == target) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = start; i < candidates.length; i++) {
                int num = candidates[i];
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                curr.add(num);
                currSum += num;
                backtracking(res, curr, candidates, i + 1, currSum, target);
                currSum -= num;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
