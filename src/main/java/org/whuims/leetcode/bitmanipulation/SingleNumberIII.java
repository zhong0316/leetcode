package org.whuims.leetcode.bitmanipulation;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int xor = 0;
        int[] ret = new int[]{0, 0};
        // 让xor和每个数进行异或，最后的结果就是出现一次的两个数的异或结果
        for (int n : nums) xor ^= n;
        // 找到AXORB最右端不相同的bit
        xor &= -xor;
        for (int n : nums) ret[(xor & n) == 0 ? 0 : 1] ^= n;
        return ret;
    }
}
