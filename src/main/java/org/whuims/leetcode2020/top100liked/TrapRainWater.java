package org.whuims.leetcode2020.top100liked;

public class TrapRainWater {

    public static void main(String[] args) {
        TrapRainWater t = new TrapRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(t.trap(height));
    }

    public int trap(int[] height) {
        return trap2(height);
    }

    public int trapBruteForce(int[] height) {
        // for i range [1 : n - 2] 分别向左和向右寻找极大值，记为maxLeft, maxRight
        // res += min(maxLeft, maxRight) - height[i]
        int res = 0;
        int n = height.length;
        for (int i = 1; i <= n - 2; i++) {
            int maxLeft = height[i - 1];
            int maxRight = height[i + 1];
            int idx = i - 1;
            while (idx > 0) {
                idx--;
                maxLeft = Math.max(maxLeft, height[idx]);
            }
            idx = i + 1;
            while (idx <= n - 2) {
                idx++;
                maxRight = Math.max(maxRight, height[idx]);
            }
            int max = Math.min(maxLeft, maxRight);
            if (max > height[i]) {
                res += Math.min(maxLeft, maxRight) - height[i];
            }
        }

        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int left = height[0];
        int right = height[n - 1];
        leftMax[0] = 0;
        leftMax[1] = left;
        rightMax[1] = right;
        for (int i = 1; i < n; i++) {
            left = Math.max(left, height[i - 1]);
            leftMax[i] = left;
        }
        for (int i = n - 2; i >= 0; i--) {
            right = Math.max(right, height[i + 1]);
            rightMax[i] = right;
        }
        int res = 0;
        for (int i = 1; i <= n - 2; i++) {
            int maxLeft = leftMax[i];
            int maxRight = rightMax[i];
            int max = Math.min(maxLeft, maxRight);
            if (max > height[i]) {
                res += Math.min(maxLeft, maxRight) - height[i];
            }
        }

        return res;
    }

}