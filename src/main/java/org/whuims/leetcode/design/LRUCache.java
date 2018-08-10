package org.whuims.leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int val) {
        if (map.size() < capacity) {
            if (head == null) {
                Node node = new Node(key, val, null, null);
                this.head = node;
                map.put(key, node);
            } else {

            }
        }
    }

    public int get(int key) {
        return 0;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
