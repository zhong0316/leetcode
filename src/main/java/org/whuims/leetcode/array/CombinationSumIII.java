package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        List<List<Integer>> res = combinationSumIII.combinationSum3(3, 12);
        for (List<Integer> lis : res) {
            lis.forEach(o -> System.out.print(" " + o));
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 0 || k == 0) {
            return res;
        }
        if (n > k * 9) {
            return res;
        }
        helper(res, new ArrayList<>(), k, n, 0, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> curr, int k, int n, int index, int currSum) {
        if (currSum == n && k == 0) {
            res.add(new ArrayList<>(curr));
        }
        if (k < 0) {
            return;
        }
        for (int i = index; i < 9; i++) {
            int num = i + 1;
            curr.add(num);
            currSum += num;
            helper(res, curr, k - 1, n, i + 1, currSum);
            curr.remove(curr.size() - 1);
            currSum -= num;
        }
    }
}
