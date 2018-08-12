package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        int depthOfLeft = depthOfTree(root.left);
        int depthOfRight = depthOfTree(root.right);
        if (depthOfLeft == depthOfRight) {
            return root;
        }
        return depthOfLeft < depthOfRight ? subtreeWithAllDeepest(root.right) : subtreeWithAllDeepest(root.left);
    }

    private int depthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }
}
