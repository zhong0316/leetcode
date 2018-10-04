package org.whuims.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stack;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        int size = stack.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            list.add(stack.pop());
        }
        int res = stack.pop();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.add(list.get(i));
        }
        return res;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        int size = stack.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(stack.pop());
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.add(list.get(i));
        }
        return list.get(size - 1);
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack.isEmpty();
    }
}
