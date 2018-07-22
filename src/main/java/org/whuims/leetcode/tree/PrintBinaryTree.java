package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PrintBinaryTree {

    public static void main(String[] args) {
        PrintBinaryTree printBinaryTree = new PrintBinaryTree();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        List<List<String>> res = printBinaryTree.printTree(root);
        res.forEach(o -> {
            o.stream().forEach(r -> System.out.print(" " + r));
            System.out.println();
        });
    }

    public List<List<String>> printTree(TreeNode treeNode) {
        List<List<String>> res = new ArrayList<>();
        if (treeNode == null) {
            return res;
        }
        int height = getHeight(treeNode);
        int rows = height, cols = (int) Math.pow(2, height) - 1;
        List<String> colString = new ArrayList<>(cols);
        for (int i = 0; i < cols; i++) {
            colString.add("");
        }
        for (int i = 0; i < rows; i++) {
            res.add(new ArrayList<>(colString));
        }
        helper(treeNode, 0, 0, cols - 1, res);
        return res;
    }

    private void helper(TreeNode treeNode, int height, int left, int right, List<List<String>> res) {
        if (treeNode == null) {
            return;
        }
        int colIndex = (left + right) / 2;
        res.get(height).set(colIndex, String.valueOf(treeNode.val));
        helper(treeNode.left, height + 1, left, colIndex - 1, res);
        helper(treeNode.right, height + 1, colIndex + 1, right, res);
    }

    private int getHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getHeight(treeNode.left) + 1, getHeight(treeNode.right) + 1);
    }
}
