package org.whuims.leetcode.dfs;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<List<Integer>> stack = new LinkedList<>();
        Deque<TreeNode> levelStack = new LinkedList<>();
        levelStack.offer(root);
        while (!levelStack.isEmpty()) {
            int size = levelStack.size();
            List<Integer> levelRes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = levelStack.poll();
                levelRes.add(temp.val);
                if (temp.left != null) {
                    levelStack.offer(temp.left);
                }
                if (temp.right != null) {
                    levelStack.offer(temp.right);
                }
            }
            stack.offer(levelRes);
        }
        while (!stack.isEmpty()) {
            res.add(stack.pollLast());
        }
        return res;
    }
}
