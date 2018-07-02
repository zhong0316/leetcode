package org.whuims.leetcode.twopointers;

public class SubarrayProductLessThanK {

    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        int[] nums = {10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3};
        int res = subarrayProductLessThanK.numSubarrayProductLessThanK(nums, 19);
        System.out.println(res);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int prod = 1;
        int left = 0, res = 0;
        for (int i = 0; i < len; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }
}
