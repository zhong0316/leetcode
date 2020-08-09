package org.whuims.leetcode2020.top100liked;

import java.util.HashMap;
import java.util.Map;

import org.whuims.leetcode.TreeNode;

public class ConstructBSTFromInAndPreOrder {

    public static void main(String[] args) {
        ConstructBSTFromInAndPreOrder c = new ConstructBSTFromInAndPreOrder();
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode res = c.buildTree(preorder, inorder);
        System.out.println(res.val);
    }

    /**
     * For example, given
     * 
     * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following binary
     * tree:
     * 
     * 
     */
    // 3
    // / \
    // 9 20
    // / \
    // 15 7
    Map<Integer, Integer> inMap = new HashMap();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inMap.put(inorder[i], i);
        }
        return construct(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int idx = inMap.get(val);
        int leftSize = idx - inStart;
        root.left = construct(preorder, inorder, preStart + 1, preStart + leftSize, inStart, idx - 1);
        root.right = construct(preorder, inorder, preStart + leftSize + 1, preEnd, idx + 1, inEnd);

        return root;
    }

    private TreeNode buildNode(int[] preorder, int[] inorder, int i, int j) {
        if (i > j) {
            return null;
        }
        if (i == j) {
            return new TreeNode(inorder[i]);
        }

        for (int k = 0; k < preorder.length; k++) {
            int target = preorder[k];
            for (int l = i; l <= j; l++) {
                if (inorder[l] == target) {
                    TreeNode root = new TreeNode(target);
                    root.left = buildNode(preorder, inorder, i, l - 1);
                    root.right = buildNode(preorder, inorder, l + 1, j);
                    return root;
                }
            }
        }

        return null;
    }
}