package org.whuims.leetcode2020.top100liked;

import org.whuims.leetcode.TreeNode;

public class MaximumDeptOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}