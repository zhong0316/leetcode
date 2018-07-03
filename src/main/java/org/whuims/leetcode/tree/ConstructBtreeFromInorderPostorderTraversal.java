package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBtreeFromInorderPostorderTraversal {

    public static void main(String[] args) {
        ConstructBtreeFromInorderPostorderTraversal constructBtreeFromInorderPostorderTraversal = new ConstructBtreeFromInorderPostorderTraversal();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = constructBtreeFromInorderPostorderTraversal.buildTree(inorder, postorder);
        System.out.println();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        int n = inorder.length;
        Map<Integer, Integer> postPosition = new HashMap<>();
        for (int i = 0; i < n; i++) {
            postPosition.put(postorder[i], i);
        }
        return constructTree(inorder, postorder, 0, n - 1, postPosition);
    }

    private TreeNode constructTree(int[] inorder, int[] postorder, int left, int end, Map<Integer, Integer> postPosition) {
        int maxPos = 0, mid = 0;
        for (int i = left; i <= end; i++) {
            if (postPosition.get(inorder[i]) > maxPos) {
                maxPos = postPosition.get(inorder[i]);
                mid = i;
            }
        }
        if (left > end || left < 0 || end > inorder.length) {
            return null;
        }
        if (left == end) {
            return new TreeNode(inorder[left]);
        }
        TreeNode root = new TreeNode(postorder[maxPos]);
        root.left = constructTree(inorder, postorder, left, mid - 1, postPosition);
        root.right = constructTree(inorder, postorder, mid + 1, end, postPosition);
        return root;
    }
}
