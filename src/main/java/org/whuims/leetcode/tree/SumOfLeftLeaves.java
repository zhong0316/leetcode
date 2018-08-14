package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class SumOfLeftLeaves {

    public static void main(String[] args) {
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        int res = sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println(res);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return helper(root.left, true) + helper(root.right, false);
    }
}
