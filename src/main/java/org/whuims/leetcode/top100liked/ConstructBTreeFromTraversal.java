package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTreeFromTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndex);
    }

    private TreeNode construct(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map<Integer, Integer> inorderIndex) {
        if (prestart > preend || instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = inorderIndex.get(preorder[prestart]);
        int leftNum = inRoot - instart;
        root.left = construct(preorder, prestart + 1, prestart + leftNum, inorder, instart, inRoot - 1, inorderIndex);
        root.right = construct(preorder, prestart + leftNum + 1, preend, inorder, inRoot + 1, inend, inorderIndex);
        return root;
    }
}
