package org.whuims.leetcode.binarysearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {

    public static void main(String[] args) {
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        int[] nums = {1, 3, 1};
        int k = 3;
        int res = findKthSmallestPairDistance.smallestDistancePair(nums, k);
        System.out.println(res);
    }

    /**
     * 二分查找，计算数对差值小于mid的个数并与k比较
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int low = 0, high = 1000000;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            // 此处如果返回值等于k不能直接作为结果返回，因为有可能mid作为差值在数组的所有差值中并不存在，需要继续搜索
            if (diffLessThan(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    private int diffLessThan(int[] nums, int diff) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] < diff) {
                j++;
                res++;
            }
        }
        return res;
    }
}
