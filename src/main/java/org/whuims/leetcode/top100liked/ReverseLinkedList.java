package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return recursion(head);
    }

    private ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
