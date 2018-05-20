package org.whuims.leetcode.top100liked;

public class MergeTwoBTree {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        if (t1 == null && t2 == null) {
            return new TreeNode(0);
        }
        TreeNode res = recur(t1, t2);
        return res;
    }

    private TreeNode recur(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode res = new TreeNode(0);
        if (t1 == null && t2 != null) {
            res.val = t2.val;
        } else if (t1 != null && t2 == null) {
            res.val = t1.val;
        } else {
            res.val = t1.val + t2.val;
        }
        res.left = recur(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        res.right = recur(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return res;
    }
}
