package org.whuims.leetcode2020.top100liked;

import java.util.Stack;

public class MaximalRectangle {

    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        // char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '0', '1', '1' },
        // { '1', '1', '1', '1', '1' },
        // { '1', '0', '0', '1', '0' } };
        char[][] matrix = { { '1', '0', '1', '1', '0', '1' }, { '1', '1', '1', '1', '1', '1' },
                { '0', '1', '1', '0', '1', '1' }, { '1', '1', '1', '0', '1', '0' }, { '0', '1', '1', '1', '1', '1' },
                { '1', '1', '0', '1', '1', '1' } };

        // char[][] matrix = { { '0', '1', '1', '0', '1' }, { '1', '1', '0', '1', '0' },
        // { '0', '1', '1', '1', '0' },
        // { '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1' }, { '0', '0', '0',
        // '0', '0' } };
        System.out.println(m.maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] prev = new int[n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] histogram = buildHistogram(matrix, i, prev);
            res = Math.max(res, largestRectangleArea(histogram));
            prev = histogram;
        }
        return res;
    }

    private int[] buildHistogram(char[][] matrix, int i, int[] prev) {
        int n = matrix[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '1') {
                res[j] = prev[j] + 1;
            }
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
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