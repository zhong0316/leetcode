package org.whuims.leetcode.top100liked;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int a = 0, b = height.length - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while (a <= b) {
            leftMax = Math.max(leftMax, height[a]);
            rightMax = Math.max(rightMax, height[b]);
            if (leftMax < rightMax) {
                res += (leftMax - height[a]);
                a++;
            } else {
                res += (rightMax - height[b]);
                b--;
            }
        }
        return res;
    }
}
