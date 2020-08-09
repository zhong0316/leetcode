package org.whuims.leetcode2020.linkedlist;

import org.whuims.leetcode.ListNode;

public class LinkedListCycleII {
    public static void main(String[] args) {
        LinkedListCycleII l = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        ListNode res = l.detectCycle(head);
        System.out.println(res.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }

        return null;
    }
}