package org.whuims.leetcode.dfs;

import java.util.*;

public class IncreasingSubsequences {

    public static void main(String[] args) {
        IncreasingSubsequences increasingSubsequences = new IncreasingSubsequences();
        int[] nums = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        List<List<Integer>> res = increasingSubsequences.findSubsequences(nums);
        res.stream().forEach(o -> {
            o.stream().forEach(r -> System.out.print(" " + r));
            System.out.println();
        });
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        dfs(nums, new boolean[n], n, new LinkedList<>(), res, 0);
        return new ArrayList<>(res);
    }

    private void dfs(int[] nums, boolean[] visit, int n, LinkedList<Integer> curr, Set<List<Integer>> res, int start) {
        if (curr.size() > 1) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = start; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            if (curr.size() > 0 && nums[i] < curr.peekLast()) {
                continue;
            }
            visit[i] = true;
            curr.add(nums[i]);
            dfs(nums, visit, n, curr, res, i + 1);
            curr.remove(curr.size() - 1);
            visit[i] = false;
        }
    }
}
