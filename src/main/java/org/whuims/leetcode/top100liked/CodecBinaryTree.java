package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CodecBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        StringBuilder stringBuilder = new StringBuilder();
        buildString(root, stringBuilder);
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] valArr = data.split(",");
        Queue<String> deque = new LinkedList<>();
        for (String str : valArr) {
            deque.offer(str);
        }
        return buildTree(deque);
    }

    private TreeNode buildTree(Queue<String> deque) {
        String val = deque.poll();
        if (val == null) {
            return null;
        }
        if (val.equals(String.valueOf(Integer.MAX_VALUE))) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = buildTree(deque);
            root.right = buildTree(deque);
            return root;
        }
    }

    private void buildString(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append(Integer.MAX_VALUE + ",");
        } else {
            stringBuilder.append(root.val + ",");
            buildString(root.left, stringBuilder);
            buildString(root.right, stringBuilder);
        }
    }
}
