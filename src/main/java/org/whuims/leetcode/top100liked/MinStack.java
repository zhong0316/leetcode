package org.whuims.leetcode.top100liked;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinStack {

    private LinkedList<Integer> ll = new LinkedList<>();
    private PriorityQueue<Integer> qu = new PriorityQueue<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        ll.add(x);
        qu.offer(x);
    }

    public void pop() {
        int o = ll.get(ll.size() - 1);
        ll.removeLast();
        qu.remove(o);
    }

    public int top() {
        return ll.get(ll.size() - 1);
    }

    public int getMin() {
        return qu.peek();
    }
}
