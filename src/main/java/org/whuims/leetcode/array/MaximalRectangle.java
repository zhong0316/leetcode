package org.whuims.leetcode.array;

import java.util.Stack;

public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            res = Math.max(res, largestRectangleArea(dp));
        }
        return res;
    }

    private int largestRectangleArea(int[] dp) {
        int len = dp.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : dp[i]);
            if (s.isEmpty() || h >= dp[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                int width = s.isEmpty() ? i : i - 1 - s.peek();
                int temp = dp[tp] * width;
                maxArea = Math.max(maxArea, temp);
                i--;
            }
        }
        return maxArea;
    }
}
