package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        backtracking(res, new ArrayList<>(), 0, target, candidates);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> cur, int index, int spare, int[] nums) {
        if (spare == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            res.add(temp);
        } else if (spare > 0) {
            for (int i = index; i < nums.length && spare >= nums[i]; i++) {
                cur.add(nums[i]);
                backtracking(res, cur, i, spare - nums[i], nums);
                cur.remove(cur.size() - 1);
            }
        } else {

        }
    }
}
