package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = reverseLinkedListII.reverseBetween(head, 1, 2);
        System.out.println();
    }

    // Divide the list to three parts:
    // 1)Nodes before m keep still;
    // 2)Traverse m~n nodes;
    // 3)Nodes after n keep still.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstTail = dummy;
        int k = m - 1;
        // The (m-1) node is the tail of first tail.
        while (k > 0) {
            firstTail = firstTail.next;
            k--;
        }
        // The m-th node is the traversed tail.
        ListNode secondTail = firstTail.next;
        // Traverse m~n nodes, and get the traversed head.
        ListNode currNode = firstTail.next;
        ListNode tempHead = null;
        ListNode tempNext = null;
        k = n - m + 1;
        while (k > 0) {
            tempHead = currNode;
            currNode = currNode.next;
            tempHead.next = tempNext;
            tempNext = tempHead;
            k--;
        }
        firstTail.next = tempHead;
        secondTail.next = currNode;
        return dummy.next;
    }
}
