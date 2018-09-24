package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReorderList {

    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList.reorderList(head);
        System.out.println();
    }

    public void reorderList(ListNode head) {
        ListNode curr = head;
        int size = getSize(curr);
        if (size <= 2) return;
        curr = head;
        List<ListNode> rightPart = new ArrayList<>();
        int count = 0, half = size % 2 == 0 ? size / 2 : size / 2 + 1;
        while (curr != null) {
            if (count >= half) {
                rightPart.add(curr);
            }
            ListNode next = curr.next;
            // 如果长度为奇数，并且当前节点为左半部分最后一个节点，则把当前节点的next置为null
            if (count == half - 1) {
                curr.next = null;
            }
            curr = next;
            count++;
        }
        curr = head;
        for (int i = 0; i < rightPart.size(); i++) {
            ListNode next = curr.next;
            ListNode right = rightPart.get(rightPart.size() - i - 1);
            curr.next = right;
            right.next = next;
            curr = next;
        }
    }

    private int getSize(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
