package org.whuims.leetcode2020.dp;

public class WiggleSubsequence {

    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        int[] nums = { 1, 2, 4, 4, 2, 2 };
        System.out.println(wiggleSubsequence.wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        // 到i是上升的
        int[] dp1 = new int[n + 1];
        // 到i是下降的
        int[] dp2 = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    dp1[i] = Math.max(dp1[i], dp2[j] + 1);
                }

                if (nums[j - 1] > nums[i - 1]) {
                    dp2[i] = Math.max(dp2[i], dp1[j] + 1);
                }
            }
        }

        return Math.max(dp1[n], dp2[n]);
    }
}