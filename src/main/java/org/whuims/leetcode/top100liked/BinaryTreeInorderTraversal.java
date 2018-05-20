package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversalRecur(root, res);
        return res;
    }

    private void inorderTraversalRecur(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversalRecur(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversalRecur(root.right, res);
        }
    }

}
