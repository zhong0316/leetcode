package org.whuims.leetcode2020.top100liked;

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(h.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] rob = new int[n + 1];
        int[] notRob = new int[n + 1];
        for (int i = 0; i < n; i++) {
            rob[i + 1] = notRob[i] + nums[i];
            notRob[i + 1] = notRob[i];
            if (i > 0) {
                notRob[i + 1] = Math.max(notRob[i], rob[i]);
            }
        }

        return Math.max(rob[n], notRob[n]);
    }
}