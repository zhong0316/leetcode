package org.whuims.leetcode.design;

import org.whuims.leetcode.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode curr = stack.pop();
        pushAll(curr.right);
        return curr.val;
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
