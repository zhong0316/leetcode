package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode newHead = removeDuplicatesFromSortedListII.deleteDuplicates(head);
        System.out.println();
    }

//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Map<Integer, Integer> freq = new HashMap<>();
//        ListNode prev = null, curr = head;
//        while (curr != null) {
//            int val = curr.val;
//            freq.put(val, freq.getOrDefault(val, 0) + 1);
//            curr = curr.next;
//        }
//        curr = head;
//        ListNode newHead = null;
//        while (curr != null) {
//            while (curr != null && freq.get(curr.val) != 1) {
//                curr = curr.next;
//            }
//            if (newHead == null) newHead = curr;
//            if (prev != null) {
//                prev.next = curr;
//            }
//            prev = curr;
//            if (curr == null) break;
//            curr = curr.next;
//        }
//        return newHead;
//    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
