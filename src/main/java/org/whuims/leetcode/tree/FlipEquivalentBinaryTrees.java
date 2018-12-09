package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
    }
}
