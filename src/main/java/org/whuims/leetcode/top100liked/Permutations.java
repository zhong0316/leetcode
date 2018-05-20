package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, nums.length - 1, res);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res) {
        if (index < 0) {
            return;
        }
        if (index == nums.length - 1) {
            List<Integer> delta = new ArrayList<>();
            delta.add(nums[index]);
            res.add(delta);
        } else {
            Iterator<List<Integer>> it = res.iterator();
            List<List<Integer>> delta = new ArrayList<>();
            while (it.hasNext()) {
                List<Integer> now = it.next();
                for (int i = 0; i < now.size() + 1; i++) {
                    List<Integer> temp = new ArrayList<>(now);
                    temp.add(i, nums[index]);
                    delta.add(temp);
                }
            }
            res.clear();
            res.addAll(delta);
        }
        dfs(nums, index - 1, res);
    }
}
