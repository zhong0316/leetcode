package org.whuims.leetcode2020.top100liked;

import org.whuims.leetcode.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList r = new ReverseLinkedList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode res = r.reverseListNode(head);
        System.out.println(res.val);
    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}