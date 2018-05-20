package org.whuims.leetcode.top100liked;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return (l1 == null && l2 == null) ? null : (l1 == null ? l2 : l1);
        }
        ListNode l3 = new ListNode(l1.val + l2.val);
        ListNode curr = l3;
        ListNode next = null;
        while (l1.next != null || l2.next != null) {
            if (l1.next != null && l2.next != null) {
                next = new ListNode(l1.next.val + l2.next.val);
                curr.next = next;
                l1 = l1.next;
                l2 = l2.next;
                curr = curr.next;
            } else if (l1.next != null && l2.next == null) {
                next = new ListNode(l1.next.val);
                curr.next = next;
                l1 = l1.next;
                curr = curr.next;
            } else {
                next = new ListNode(l2.next.val);
                curr.next = next;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        // Carry process
        ListNode aCurr = l3;
        while (aCurr.next != null) {
            ListNode temp = aCurr;
            int carry = 0;
            if (aCurr.val >= 10) {
                carry = aCurr.val / 10;
                aCurr.val = aCurr.val % 10;
                aCurr.next.val += carry;
            }
            aCurr = temp.next;
        }
        if (aCurr.val >= 10) {
            aCurr.next = new ListNode(aCurr.val / 10);
            aCurr.val = aCurr.val % 10;
        }
        return l3;
    }
}
