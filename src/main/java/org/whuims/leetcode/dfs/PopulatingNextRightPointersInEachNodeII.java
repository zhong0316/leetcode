package org.whuims.leetcode.dfs;

import org.whuims.leetcode.TreeLinkNode;

import java.util.Deque;
import java.util.LinkedList;

public class PopulatingNextRightPointersInEachNodeII {

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII populatingNextRightPointersInEachNodeII = new PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode root = new TreeLinkNode(1, new TreeLinkNode(2, new TreeLinkNode(4), new TreeLinkNode(5)), new TreeLinkNode(3, null, new TreeLinkNode(7)));
        populatingNextRightPointersInEachNodeII.connect(root);
        System.out.println();
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Deque<TreeLinkNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = deque.poll();
                if (i < size - 1) {
                    temp.next = deque.peekFirst();
                }
                if (temp.left != null) deque.offer(temp.left);
                if (temp.right != null) deque.offer(temp.right);
            }
        }
    }
}
