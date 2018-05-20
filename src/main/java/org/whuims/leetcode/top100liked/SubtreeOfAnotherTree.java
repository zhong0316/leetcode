package org.whuims.leetcode.top100liked;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(s);
        while (!que.isEmpty()) {
            TreeNode source = que.poll();
            if (isSameTree(source, t)) {
                return true;
            }
            if (source.left != null) {
                que.add(source.left);
            }
            if (source.right != null) {
                que.add(source.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null && t != null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        if ((s.left != null && t.left == null) || (s.left == null && t.left != null)) {
            return false;
        }
        if ((s.right != null && t.right == null) || (s.right == null && t.right != null)) {
            return false;
        }
        if (s.left == null) {
            return isSameTree(s.right, t.right);
        } else if (s.right == null) {
            return isSameTree(s.left, t.left);
        } else {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
