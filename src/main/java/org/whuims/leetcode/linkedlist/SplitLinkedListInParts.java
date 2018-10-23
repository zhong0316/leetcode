package org.whuims.leetcode.linkedlist;

import org.whuims.leetcode.ListNode;

public class SplitLinkedListInParts {

    public static void main(String[] args) {
        SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts();
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode[] res = splitLinkedListInParts.splitListToParts(root, 1);
        for (ListNode node : res) {
            System.out.println(node);
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = getSize(root);
        if (n == 0) return new ListNode[k];
        if (k == 1) return new ListNode[]{root};
        ListNode[] res = new ListNode[k];
        int meanNum = n / k;
        int modNum = n % k;
        ListNode curr = root, prev = null;
        int counter = 0;
        int i = 0;
        while (i < k && curr != null) {
            int step = meanNum;
            if (i < modNum) step += 1;
            res[counter++] = curr;
            while (step-- > 0 && curr != null) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            prev = curr;
            i++;
        }
        return res;
    }
    private int getSize(ListNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.next;
        }
        return res;
    }
}
