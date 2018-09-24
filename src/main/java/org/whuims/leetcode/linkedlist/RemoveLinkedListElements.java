package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

public class RemoveLinkedListElements {

    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
//        ListNode head = new ListNode(1, new ListNode(1));
        ListNode newHead = removeLinkedListElements.removeElements(head, 6);
        removeLinkedListElements.printLinkedList(newHead);
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode curr = head, dummy = new ListNode(-1);
        dummy.next = curr;
        ListNode prev = dummy;
        while (curr != null) {
            while (curr != null && curr.val == val) {
                curr = curr.next;
            }
            if (curr != null) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = null;
            }
        }
        return dummy.next;
    }

    private void printLinkedList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
    }
}
