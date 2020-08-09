package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> res = p.permute(nums);
        System.out.println(res.size());
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int n = nums.length;
        boolean[] visit = new boolean[n];
        backtracking(nums, 0, visit, new ArrayList<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int i, boolean[] visit, List<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visit[j]) {
                continue;
            }
            visit[j] = true;
            curr.add(nums[j]);
            backtracking(nums, i + 1, visit, curr, res);
            visit[j] = false;
            curr.remove(curr.size() - 1);
        }
    }
}