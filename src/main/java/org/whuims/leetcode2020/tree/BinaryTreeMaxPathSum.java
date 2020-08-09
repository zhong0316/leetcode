package org.whuims.leetcode2020.tree;

import java.util.ArrayList;
import java.util.List;

import org.whuims.leetcode.TreeNode;

public class BinaryTreeMaxPathSum {
    public static void main(String[] args) {
        BinaryTreeMaxPathSum b = new BinaryTreeMaxPathSum();
        TreeNode root = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(b.maxPathSum(root));
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        res = Math.max(res, root.val + left + right);
        return Math.max(left, right) + root.val;
    }
}