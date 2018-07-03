package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        BinaryTreePreorderTraversal preorderTraversal = new BinaryTreePreorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> res = preorderTraversal.preorderTraversal(root);
        res.stream().forEach(o -> System.out.print(" " + o));
        System.out.println();

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
}
