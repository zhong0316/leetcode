package org.whuims.leetcode.topinterview;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayDeque;

public class MaximumDepthOfBTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode curr = queue.remove();
            int depthCurr = depth(curr);
            if (depthCurr > max) max = depthCurr;
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
        return max;
    }

    int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
