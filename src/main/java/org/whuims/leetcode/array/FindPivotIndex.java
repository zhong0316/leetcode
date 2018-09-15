package org.whuims.leetcode.array;

public class FindPivotIndex {

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = {1,2,3};
        int res = findPivotIndex.pivotIndex(nums);
        System.out.println(res);
    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        int len = nums.length, sum = 0;
        for (int num : nums) sum += num;
        int leftSum = 0, rightSum = sum - nums[0];
        for (int i = 0; i < len; i++) {
            if (leftSum == rightSum) {
                return i;
            } else {
                leftSum += nums[i];
                if (i < len - 1) rightSum -= nums[i + 1];
            }
        }
        return -1;
    }
}
