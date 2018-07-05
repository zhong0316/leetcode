package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BTreeCodec {

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), null);
//        root.right = new TreeNode(3, new TreeNode(4, null, null), new TreeNode(5, null, null));
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.left = new TreeNode(-1);
//        root.left.left = new TreeNode(-2);
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(3, new TreeNode(2), new TreeNode(4)));
        BTreeCodec bTreeCodec = new BTreeCodec();
        String serialized = bTreeCodec.serialize(root);
        System.out.println(serialized);
        TreeNode constructed = bTreeCodec.deserialize(serialized);
        System.out.println(constructed);
    }

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
