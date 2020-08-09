package org.whuims.leetcode2020.top100liked;

/**
 * two pointer
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(c.maxArea(height));
    }

    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int res = 0;
        int n = height.length;
        // for (int i = 0; i < n; i++) {
        // for (int j = n - 1; j > i; j--) {
        // int tmp = Math.min(height[i], height[j]);
        // res = Math.max(res, tmp * (j - i));
        // }
        // }

        // return res;

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}