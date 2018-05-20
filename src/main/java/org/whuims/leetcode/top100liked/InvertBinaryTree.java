package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertRecur(root);
        return root;
    }

    private void invertRecur(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertRecur(root.left);
        invertRecur(root.right);
    }
}
