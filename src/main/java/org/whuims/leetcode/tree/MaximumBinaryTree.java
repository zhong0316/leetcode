package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        return buildTree(nums, 0, len - 1, len);
    }

    private TreeNode buildTree(int[] nums, int start, int end, int len) {
        if (start < 0 || end >= len || start > end) {
            return null;
        }
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, start, maxIndex - 1, len);
        root.right = buildTree(nums, maxIndex + 1, end, len);
        return root;
    }
}
