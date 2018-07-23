package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsII.subsetsWithDup(nums);
        res.stream().forEach(o -> {
            o.stream().forEach(r -> System.out.print(" " + r));
            System.out.println();
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> curr, int start, int[] nums) {
        if (start > nums.length) {
            return;
        }
        res.add(new ArrayList<>(curr));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtracking(res, curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }
}
