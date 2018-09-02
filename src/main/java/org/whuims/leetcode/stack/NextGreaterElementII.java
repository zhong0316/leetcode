package org.whuims.leetcode.stack;

import java.util.Stack;

public class NextGreaterElementII {

    // two traverse
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        if (len == 1) {
            return new int[]{-1};
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        int n = 2;
        while (n > 0) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    res[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
            n--;
        }

        return res;
    }
}
