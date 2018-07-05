package org.whuims.leetcode.array;

public class ContiguousArray {

    public static void main(String[] args) {
        ContiguousArray ct = new ContiguousArray();
        System.out.println(ct.findMaxLength(new int[]{0, 0, 0, 1, 1, 1, 0}));
    }
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 2 && nums[0] + nums[1] == 1) {
            return 2;
        }
        int start = 0, end = start + 1;
        int max = 0;
        while (start < len && end < len) {
            if (nums[end] + nums[end - 1] == 1) {
                if (end - start + 1 > max) {
                    max = end - start + 1;
                }
                if (end < len - 2) {
                    end += 2;
                } else {
                    break;
                }
            } else {
                start = end;
                end++;
            }
        }
        return max;
    }
}
