package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class ConstructBinarySearchTreeFromPreorderTraversal {

    public static void main(String[] args) {
        ConstructBinarySearchTreeFromPreorderTraversal constructBinarySearchTreeFromPreorderTraversal = new ConstructBinarySearchTreeFromPreorderTraversal();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode root = constructBinarySearchTreeFromPreorderTraversal.bstFromPreorder(preorder);
        System.out.println();
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            construct(root, preorder[i]);
        }
        return root;
    }

    private void construct(TreeNode root, int val) {
        if (root.left != null && val < root.val) construct(root.left, val);
        if (root.right != null && val > root.val) construct(root.right, val);
        if (root.left == null && val < root.val) root.left = new TreeNode(val);
        if (root.right == null && val > root.val) root.right = new TreeNode(val);
    }
}
