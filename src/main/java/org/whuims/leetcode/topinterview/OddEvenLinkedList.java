package org.whuims.leetcode.topinterview;

import org.whuims.leetcode.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            ListNode oddNextNext = odd.next.next;
            ListNode evenNextNext = even.next.next;
            odd.next = oddNextNext;
            even.next = evenNextNext;
            odd = oddNextNext;
            even = evenNextNext;
        }
        odd.next = evenHead;
        return head;
    }
}
