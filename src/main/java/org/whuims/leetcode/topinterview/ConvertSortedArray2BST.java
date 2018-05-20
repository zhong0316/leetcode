package org.whuims.leetcode.topinterview;

import org.whuims.leetcode.TreeNode;

public class ConvertSortedArray2BST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructTree(0, nums.length, nums);
    }

    private TreeNode constructTree(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        if (mid >= nums.length) {
            return null;
        }
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(start, mid - 1, nums);
        root.right = constructTree(mid + 1, end, nums);
        return root;
    }
}
