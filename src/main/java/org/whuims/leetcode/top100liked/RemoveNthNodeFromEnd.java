package org.whuims.leetcode.top100liked;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head, prev = curr, newHead = head;
        int total = 0;
        while (newHead != null) {
            total++;
            newHead = newHead.next;
        }
        if (total == 1) {
            return null;
        }
        if (total == n) {
            return head.next;
        }
        int counter = 0;
        while (counter < total - n && curr != null) {
            prev = curr;
            curr = curr.next;
            counter++;
        }
        if (curr == null) {
            prev.next = null;
        } else {
            prev.next = curr.next;
        }
        return head;
    }
}
