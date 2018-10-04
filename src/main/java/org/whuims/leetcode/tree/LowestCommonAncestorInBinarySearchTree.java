package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class LowestCommonAncestorInBinarySearchTree {

    public static void main(String[] args) {
        LowestCommonAncestorInBinarySearchTree lowestCommonAncestorInBinarySearchTree = new LowestCommonAncestorInBinarySearchTree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(lowestCommonAncestorInBinarySearchTree.lowestCommonAncestor(root, right, rightLeft).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, q, p);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }
}
