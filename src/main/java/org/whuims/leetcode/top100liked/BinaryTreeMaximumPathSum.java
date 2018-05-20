package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recursive(root);
        return max;
    }

    private int recursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        int left = Math.max(0, recursive(root.left));
        int right = Math.max(0, recursive(root.right));
        max = Math.max(val + left + right, max);
        return val + Math.max(left, right);
    }
}
