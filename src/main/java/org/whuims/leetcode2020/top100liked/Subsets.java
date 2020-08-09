package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res.size());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            backtracking(new ArrayList<>(), res, 0, i, nums);
        }
        return res;
    }

    private void backtracking(List<Integer> curr, List<List<Integer>> res, int i, int counter, int[] nums) {
        if (curr.size() == counter) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (i >= nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtracking(curr, res, j + 1, counter, nums);
            curr.remove(curr.size() - 1);
        }
    }
}