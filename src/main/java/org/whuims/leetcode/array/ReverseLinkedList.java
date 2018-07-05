package org.whuims.leetcode.array;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = buildLinkedListFromArray(new int[]{1, 2, 3, 4, 5});
        ListNode reversed = reverseRecursive(head);
        System.out.println();
    }

    static ListNode buildLinkedListFromArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode curr = new ListNode(arr[i]);
            prev.next = curr;
            prev = prev.next;
        }
        return head;
    }

    static ListNode reverseLinkedList(ListNode reverseHead) {
        ListNode prev = reverseHead;
        ListNode curr = reverseHead.next;
        prev.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = reverseLinkedList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }
}

class ListNode {
    public ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }
}
