package org.whuims.leetcode.top100liked;

import org.whuims.leetcode.ListNode;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode mergeLeft = sortList(head);
        ListNode mergeRight = sortList(slow);
        return merge(mergeLeft, mergeRight);
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
