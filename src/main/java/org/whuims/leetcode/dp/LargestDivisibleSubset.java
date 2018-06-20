package org.whuims.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> res = largestDivisibleSubset.largestDivisibleSubset(new int[]{2,3,8,9,27});
        for (int num : res) {
            System.out.print(" " + num);
        }
        System.out.println();
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }
        int temp = nums[maxIndex];
        int currDp = dp[maxIndex];
        List<Integer> res = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[i] == currDp) {
                res.add(nums[i]);
                currDp--;
                temp = nums[i];
            }
        }
        return res;
    }
}
