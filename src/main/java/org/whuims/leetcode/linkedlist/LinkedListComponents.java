package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public int numComponents(ListNode head, int[] G) {
        if (head == null) {
            return 0;
        }
        if (head.next == null) {
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : G) {
            set.add(num);
        }
        int res = G.length;
        while (head.next != null) {
            int curr = head.val, nextVal = head.next.val;
            if (set.contains(curr) && set.contains(nextVal)) {
                res--;
            }
            head = head.next;
        }
        return res;
    }

}
