package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        ListNode newHead = removeDuplicatesFromSortedList.deleteDuplicates(head);
        System.out.println();
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        int currVal = curr.val;
        while (curr != null) {
            ListNode next = curr.next;
            if (next == null) {
                break;
            }
            while (next != null && currVal == next.val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
            if (curr != null) {
                currVal = curr.val;
            }
        }
        return head;
    }
}
