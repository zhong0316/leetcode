package org.whuims.leetcode.dp;

public class RangeSumQueryImmutable {

    private int[] dp;

    public RangeSumQueryImmutable(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        RangeSumQueryImmutable rangeSumQueryImmutable = new RangeSumQueryImmutable(nums);
        System.out.println(rangeSumQueryImmutable.sumRange(0, 5));
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
