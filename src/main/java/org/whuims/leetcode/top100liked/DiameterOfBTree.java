package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

public class DiameterOfBTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        recursiveLen(root);
        return max;
    }

    private int recursiveLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recursiveLen(root.left);
        int right = recursiveLen(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
