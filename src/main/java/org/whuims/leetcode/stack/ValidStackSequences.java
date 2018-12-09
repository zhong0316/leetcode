package org.whuims.leetcode.stack;

import java.util.LinkedList;

public class ValidStackSequences {

    public static void main(String[] args) {
        ValidStackSequences validStackSequences = new ValidStackSequences();
        int[] pushed = {1,2,3,4,5};
        int[] popped = {5,4,3,2};
        System.out.println(validStackSequences.validateStackSequences(pushed, popped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int n = pushed.length;
        if (popped.length > n) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            linkedList.offerLast(pushed[i]);
            while (!linkedList.isEmpty() && j < popped.length && linkedList.peekLast() == popped[j]) {
                j++;
                linkedList.pollLast();
            }
        }
        while (!linkedList.isEmpty() && j < popped.length) {
            if (linkedList.pollLast() != popped[j++]) {
                return false;
            }
        }
        return true;
    }
}
