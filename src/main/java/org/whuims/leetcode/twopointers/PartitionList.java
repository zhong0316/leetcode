package org.whuims.leetcode.twopointers;

import org.whuims.leetcode.ListNode;

public class PartitionList {

    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);
        ListNode newNode = partitionList.partition(head, 0);
        while (newNode != null) {
            System.out.print("->" + newNode.val);
            newNode = newNode.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode newNode = null, newHead = null;
        ListNode oldHead = null, oldCurr = null;
        while (curr != null) {
            int val = curr.val;
            if (val < x) {
                if (newNode == null) {
                    newNode = curr;
                    newHead = newNode;
                } else {
                    newNode.next = curr;
                    newNode = newNode.next;
                }
            } else {
                if (oldCurr == null) {
                    oldCurr = curr;
                    oldHead = oldCurr;
                } else {
                    oldCurr.next = curr;
                    oldCurr = oldCurr.next;
                }
            }
            curr = curr.next;
        }
        if (oldCurr != null) {
            oldCurr.next = null;
        }
        if (newNode != null) {
            newNode.next = oldHead;
        }
        return newHead == null ? head : newHead;
    }
}
