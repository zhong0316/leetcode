package org.whuims.leetcode2020.top100liked;

import java.util.ArrayList;
import java.util.List;

import org.whuims.leetcode.TreeNode;

public class ValidateBinarySearchTrees {

    public static void main(String[] args) {
        ValidateBinarySearchTrees v = new ValidateBinarySearchTrees();
        // TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(4, new
        // TreeNode(3), new TreeNode(5)));
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15, new TreeNode(6), new TreeNode(20)));
        System.out.println(v.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}