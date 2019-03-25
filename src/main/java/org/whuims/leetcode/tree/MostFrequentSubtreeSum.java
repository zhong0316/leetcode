package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.*;

/**
 * 508. Most Frequent Subtree Sum
 * Medium
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class MostFrequentSubtreeSum {

    public static void main(String[] args){
        TreeNode treeNode = new TreeNode(3, new TreeNode(2), new TreeNode(-3));
        int[] ret = new MostFrequentSubtreeSum().findFrequentTreeSum(treeNode);
        for (int i : ret) {
            System.out.println(i);
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        Map<TreeNode, Integer> cache = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        dfs(root, cache);
        Collection<Integer> valSet = cache.values();
        valSet.forEach(val -> freq.put(val, freq.getOrDefault(val, 0) + 1));
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        Collections.sort(list, ((o1, o2) -> o2.getValue() - o1.getValue()));
        int mostFreq = list.get(0).getValue();
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getValue() == mostFreq) res.add(entry.getKey());
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ret[i] = res.get(i);
        return ret;
    }

    private void dfs(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) return;
        sumDfs(root, cache);
        dfs(root.left, cache);
        dfs(root.right, cache);
    }

    private int sumDfs(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null) return 0;
        if (cache.containsKey(root)) return cache.get(root);
        int val = root.val;
        int leftTotal = sumDfs(root.left, cache);
        int rightTotal = sumDfs(root.right, cache);
        int res = val + leftTotal + rightTotal;
        cache.put(root, res);
        return res;
    }
}
