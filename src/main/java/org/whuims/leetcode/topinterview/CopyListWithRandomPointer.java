package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        // loop 1 : copy node
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }
        // loop 2 : copy next and random
        node = head;
        while (node != null) {
            map.get(node).next = map.getOrDefault(node.next, null);
            map.get(node).random = map.getOrDefault(node.random, null);
            node = node.next;
        }
        return map.get(head);
    }
}


class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}