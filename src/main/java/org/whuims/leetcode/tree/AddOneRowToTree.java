package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {

    public static void main(String[] args) {
        AddOneRowToTree addOneRowToTree = new AddOneRowToTree();
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null);
        addOneRowToTree.printTreeLevelByLevel(root);
        addOneRowToTree.addOneRow(root, 1, 5);
        addOneRowToTree.printTreeLevelByLevel(root);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d <= 0) return root;
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (level < d - 1 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            level++;
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            TreeNode currLeft = curr.left;
            TreeNode currRight = curr.right;
            TreeNode newLeft = new TreeNode(v);
            TreeNode newRight = new TreeNode(v);
            newLeft.left = currLeft;
            newRight.right = currRight;
            curr.left = newLeft;
            curr.right = newRight;
        }
        return root;
    }

    private void printTreeLevelByLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                System.out.print(curr.val + "->");
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            System.out.println();
        }
    }
}
