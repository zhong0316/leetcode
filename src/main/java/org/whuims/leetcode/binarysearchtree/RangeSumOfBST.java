package org.whuims.leetcode.binarysearchtree;

import org.whuims.leetcode.TreeNode;

public class RangeSumOfBST {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        int val = root.val;
        if (val >= L && val <= R) {
            res += val;
        }
        if (root.left != null && root.val >= L) {
            res += rangeSumBST(root.left, L, R);
        }
        if (root.right != null && root.val <= R) {
            res += rangeSumBST(root.right, L, R);
        }
        return res;
    }
}
