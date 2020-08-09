package org.whuims.leetcode2020.top100liked;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        LargestRectangleInHistogram l = new LargestRectangleInHistogram();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(l.largestRectangleAreaStack(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i;
            maxLeft[i] = i;
            maxRight[i] = i;
            while (j > 0 && heights[i] <= heights[j - 1]) {
                j--;
                maxLeft[i] = j;
            }
            j = i;
            while (j < n - 1 && heights[i] <= heights[j + 1]) {
                j++;
                maxRight[i] = j;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max((maxRight[i] - maxLeft[i] + 1) * heights[i], max);
        }

        return max;
    }

    public int largestRectangleAreaStack(int[] heights) {
        int len = heights.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}