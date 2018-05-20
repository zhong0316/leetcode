package org.whuims.leetcode.top100liked;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        int left = 0, right = len - 1;
        while (left <= right) {
            max = Math.max(max, area(left, right, height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    private int area(int i, int j, int left, int right) {
        int ret = Math.min(right, left) * (j - i);
        return ret;
    }
}
