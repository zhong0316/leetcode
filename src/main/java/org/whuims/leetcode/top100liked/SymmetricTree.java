package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val &&
                check(left.left, right.right) && check(left.right, right.left);
    }
}
