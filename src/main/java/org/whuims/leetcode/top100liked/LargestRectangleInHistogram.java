package org.whuims.leetcode.top100liked;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[] height = {6, 2, 5, 4, 5, 1, 6};
        largestRectangleInHistogram.largestRectangleArea(height);
    }

    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                int width = s.isEmpty() ? i : i - 1 - s.peek();
                int temp = height[tp] * width;
                maxArea = Math.max(maxArea, temp);
                i--;
            }
        }
        return maxArea;
    }
}
