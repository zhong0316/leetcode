package org.whuims.leetcode.dfs;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinarySearchTree {

    public static void main(String[] args) {
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        TreeNode root = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        recoverBinarySearchTree.printTreeInorder(root);
        recoverBinarySearchTree.recoverTree(root);
        recoverBinarySearchTree.printTreeInorder(root);
    }

    private void printTreeInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            printTreeInorder(root.left);
        }
        System.out.println(root.val);
        if (root.right != null) {
            printTreeInorder(root.right);
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int n = list.size();
        List<Integer> nums = new ArrayList<>();
        for (TreeNode node : list) {
            nums.add(node.val);
        }
        Collections.sort(nums);
        for (int i = 0; i < n; i++) {
            list.get(i).val = nums.get(i);
        }
    }


    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inorder(root.right, list);
        }
    }
}
