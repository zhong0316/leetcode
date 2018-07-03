package org.whuims.leetcode.tree;

import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SumRoot2LeafNumbers {

    public static void main(String[] args) {
        SumRoot2LeafNumbers sumRoot2LeafNumbers = new SumRoot2LeafNumbers();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(0);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        int res = sumRoot2LeafNumbers.sumNumbers(root);
        System.out.println(res);
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res, new LinkedList<>());
        return res.stream().mapToInt(o -> o).sum();
    }

    private void bfs(TreeNode root, List<Integer> res, LinkedList<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.offer(root.val);
        if (root.left == null && root.right == null) {
            if (!queue.isEmpty()) {
                int num = queue.peek();
                int size = queue.size();
                for (int i = 1; i < size; i++) {
                    num *= 10;
                    num += queue.get(i);
                }
                res.add(num);
            }
        } else {
            bfs(root.left, res, queue);
            bfs(root.right, res, queue);
        }
        queue.pollLast();
    }
}
