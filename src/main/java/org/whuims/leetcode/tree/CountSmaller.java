package org.whuims.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmaller {

    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        List<Integer> res = countSmaller.countSmaller(new int[]{5, 2, 6, 1});
        System.out.println(res);
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        TreeNode root = new TreeNode(nums[nums.length - 1], 1);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            addNode(root, nums[i], res);
        }
        Collections.reverse(res);
        return res;
    }

    private void addNode(TreeNode root, int val, List<Integer> res) {
        TreeNode cur = new TreeNode(val, 1);
        int curCount = 0;
        while (true) {
            if (cur.val <= root.val) {
                root.smallerCount++;
                if (root.left == null) {
                    root.left = cur;
                    break;
                } else {
                    root = root.left;
                }
            } else {
                curCount += root.smallerCount;
                if (root.right == null) {
                    root.right = cur;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        res.add(curCount);
    }

    class TreeNode {
        int val;
        int smallerCount;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, int smallerCount) {
            this.val = val;
            this.smallerCount = smallerCount;
        }
    }
}
