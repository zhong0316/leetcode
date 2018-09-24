package org.whuims.leetcode.sort;

import java.util.Arrays;

public class MaximumGap {

    /**
     * 利用桶排序的思想：划分n-1个桶，通过当前(num - min) / gap来得到当前数字落在哪个桶内
     * 用两个数组记录当前桶内最大数和最小数，然后依次遍历桶拿第i+1个桶的最小值减去第i个桶的最大值得到可能最大的gap
     *
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int n = nums.length;
        // 计算最小的可能的gap
        int gap = (int) Math.ceil((double) (max - min) / (n - 1));
        // 分别记录第i个桶内的最大值和最小值
        int[] bucketMax = new int[n - 1];
        int[] bucketMin = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int index = (num - min) / gap;
            bucketMin[index] = Math.min(num, bucketMin[index]);
            bucketMax[index] = Math.max(num, bucketMax[index]);
        }
        int res = Integer.MIN_VALUE;
        int prev = min;
        for (int i = 0; i < n - 1; i++) {
            // 当前桶为空
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            res = Math.max(res, bucketMin[i] - prev);
            prev = bucketMax[i];
        }
        res = Math.max(res, max - prev);
        return res;
    }
}
