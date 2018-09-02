package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class BinaryTreeTilt {

    private int tilt = 0;

    public int findTilt(TreeNode root) {
        nodeTilt(root);
        return tilt;
    }

    private int nodeTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的和
        int left = nodeTilt(root.left);
        // 右子树的和
        int right = nodeTilt(root.right);
        tilt += Math.abs(left - right);
        // 左右子树各节点的和
        return left + right + root.val;
    }
}
