package org.whuims.leetcode.top100liked;

public class MajorityElement {

    public int majorityElement(int[] num) {
        // Boyer-Moore 多数投票算法
        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else {
                count--;
            }

        }
        return major;
    }
}
