package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> cur, int index, int[] nums) {
        res.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            cur.add(nums[i]);
            backtracking(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
