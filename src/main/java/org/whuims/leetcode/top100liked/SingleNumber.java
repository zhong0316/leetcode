package org.whuims.leetcode.top100liked;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (Integer num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
