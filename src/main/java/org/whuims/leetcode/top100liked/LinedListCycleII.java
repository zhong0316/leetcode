package org.whuims.leetcode.top100liked;

public class LinedListCycleII {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        ListNode slowEnd = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slowEnd = slow;
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode temp = head;
        while (temp != slowEnd) {
            temp = temp.next;
            slowEnd = slowEnd.next;
        }
        return slowEnd;
    }
}
