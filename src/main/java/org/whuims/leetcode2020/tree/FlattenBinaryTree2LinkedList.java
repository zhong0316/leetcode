package org.whuims.leetcode2020.tree;

import org.whuims.leetcode.TreeNode;

public class FlattenBinaryTree2LinkedList {

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        dfs(root.right);

        if (root.left != null) {
            TreeNode curr = root.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}