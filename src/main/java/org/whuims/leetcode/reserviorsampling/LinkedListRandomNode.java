package org.whuims.leetcode.reserviorsampling;

import org.whuims.leetcode.ListNode;

import java.util.Random;

public class LinkedListRandomNode {

    Random random;
    ListNode head;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        random = new Random();
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode curr = head;
        int r = curr.val;
        for (int i = 1; curr.next != null; i++) {
            curr = curr.next;
            if (random.nextInt(i + 1) == i) r = curr.val;
        }
        return r;
    }
}
