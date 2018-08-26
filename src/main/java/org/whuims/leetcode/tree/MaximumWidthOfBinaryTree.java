package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), null);
        int res = maximumWidthOfBinaryTree.widthOfBinaryTree(root);
        System.out.println(res);
    }

    /**
     * We know that a binary tree can be represented by an array (assume the root begins from the position with index 1 in the array).
     * If the index of a node is i, the indices of its two children are 2*i and 2*i + 1. The idea is to use two arrays (start[] and
     * end[]) to record the the indices of the leftmost node and rightmost node in each level, respectively. For each level of the
     * tree, the width is end[level] - start[level] + 1. Then, we just need to find the maximum width.
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) return 0;
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2 * order, start, end);
        int right = dfs(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
