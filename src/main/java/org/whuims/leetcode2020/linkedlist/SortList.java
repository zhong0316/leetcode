package org.whuims.leetcode2020.linkedlist;

import org.whuims.leetcode.ListNode;

public class SortList {

    public static void main(String[] args) {
        SortList s = new SortList();
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        ListNode res = s.sortList(head);
        System.out.println(res.val);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode head, ListNode slow) {
        if (head == null) {
            return slow;
        }
        if (slow == null) {
            return head;
        }
        ListNode helper = new ListNode(0), l = helper;
        while (head != null && slow != null) {
            if (head.val < slow.val) {
                l.next = head;
                head = head.next;
            } else {
                l.next = slow;
                slow = slow.next;
            }
            l = l.next;
        }
        if (head != null) {
            l.next = head;
        }
        if (slow != null) {
            l.next = slow;
        }
        return helper.next;
    }
}