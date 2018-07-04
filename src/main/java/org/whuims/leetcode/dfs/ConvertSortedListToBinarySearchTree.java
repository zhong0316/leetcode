package org.whuims.leetcode.dfs;

import org.whuims.leetcode.ListNode;
import org.whuims.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        return constructBst(list, 0, list.size() - 1, list.size());
    }

    private TreeNode constructBst(List<Integer> list, int start, int end, int n) {
        if (start < 0 || end >= n || start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = constructBst(list, start, mid - 1, n);
        root.right = constructBst(list, mid + 1, end, n);
        return root;
    }
}
