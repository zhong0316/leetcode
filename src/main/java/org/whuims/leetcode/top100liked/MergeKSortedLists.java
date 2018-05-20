package org.whuims.leetcode.top100liked;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        return merge(lists, 0, k - 1);
    }

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start < end) {
            int m = (end + start) / 2;
            return mergeTwoLists(merge(lists, start, m), merge(lists, m + 1, end));
        }
        return lists[start];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeHead = null;
        if (l1.val < l2.val) {
            mergeHead = l1;
            l1 = l1.next;
            mergeHead.next = mergeTwoLists(l1, l2);
        } else {
            mergeHead = l2;
            l2 = l2.next;
            mergeHead.next = mergeTwoLists(l1, l2);
        }
        return mergeHead;
    }
}
