package org.whuims.leetcode.array;

import java.util.Arrays;

public class ArrayPartitionI {

    public static void main(String[] args) {
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        int[] nums = {1, 2, 3, 4};
        int res = arrayPartitionI.arrayPairSum(nums);
        System.out.println(res);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[2 * i];
            res += num;
        }
        return res;
    }
}
