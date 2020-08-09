package org.whuims.leetcode2020.dp;

/**
 * 740. 删除与获得点数 给定一个整数数组 nums ，你可以对它进行一些操作。
 * 
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
 * 1 的元素。
 * 
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        DeleteAndEarn deleteAndEarn = new DeleteAndEarn();
        System.out.println(deleteAndEarn.deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10001];
        for (int num : nums) {
            sum[num] += num;
        }

        for (int i = 2; i <= 10000; i++) {
            sum[i] = Math.max(sum[i - 2] + sum[i], sum[i - 1]);
        }

        return sum[10000];
    }
}