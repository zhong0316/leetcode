package org.whuims.leetcode.binarysearch;

import org.whuims.leetcode.TreeNode;

public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));
        System.out.println(countCompleteTreeNodes.countNodes(root));
    }

    public int countNodes(TreeNode root) {
        int h;
        if ((h = height(root, true)) == height(root, false)) {
            return (1 << h) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int height(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        return isLeft ? height(node.left, isLeft) + 1 : height(node.right, isLeft) + 1;
    }
}
