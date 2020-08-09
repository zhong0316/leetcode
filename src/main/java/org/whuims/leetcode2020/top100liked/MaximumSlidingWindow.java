package org.whuims.leetcode2020.top100liked;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {
    public static void main(String[] args) {
        MaximumSlidingWindow m = new MaximumSlidingWindow();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int[] res = m.maxSlidingWindow(nums, 3);
        System.out.println(res.length);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque();
        for (int i = 0; i < k; i++) {
            if (stack.size() == 2) {
                if (nums[i] > stack.peek() || nums[i] > stack.peekLast()) {
                    stack.removeLast();
                    stack.offer(nums[i]);
                }
            } else {
                stack.add(nums[i]);
            }
        }

        int resSize = n - (k - 1);
        int[] res = new int[resSize];
        res[0] = stack.peek() > stack.peekLast() ? stack.removeFirst() : stack.removeLast();
        for (int i = 1; i < resSize; i++) {

        }

        return res;
    }
}