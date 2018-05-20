package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (list.size() > 0) {
            List<TreeNode> next = new ArrayList<>();
            for (TreeNode node : list) {
                pathSumFromRoot(node, sum);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            list.clear();
            list.addAll(next);
        }
        return count;
    }

    private void pathSumFromRoot(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (sum == root.val) {
            count++;
        }
        pathSumFromRoot(root.left, sum - root.val);
        pathSumFromRoot(root.right, sum - root.val);
    }
}
