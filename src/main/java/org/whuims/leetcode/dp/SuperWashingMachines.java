package org.whuims.leetcode.dp;

import java.util.Arrays;

public class SuperWashingMachines {

    public static void main(String[] args) {
        SuperWashingMachines superWashingMachines = new SuperWashingMachines();
        int[] machines = {0, 3, 0};
        int res = superWashingMachines.findMinMoves(machines);
        System.out.println(res);
    }

    /**
     * 思路：对于位置i，分别考虑其左边的和以及右边的和，如果都大于零，则代表两边同时需要向位置i输出衣服；
     * 如果两边都小于0，则代表位置i需要分别向两边输出衣服，但是不能同时输出；
     * 如果一边大于0，一边小于0，则需要输出绝对值最大的衣服
     * 遍历每一个位置得到minMove
     *
     * @param machines
     * @return
     */
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return 0;
        int len = machines.length;
        int total = Arrays.stream(machines).sum();
        if (total % len != 0) return -1;
        int mean = total / len;
        int minMv = 0;
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + machines[i];
        }
        for (int i = 1; i < len - 1; i++) {
            int leftCount = sum[i] - mean * i;
            int rightCount = sum[len] - sum[i + 1] - mean * (len - i - 1);
            if (leftCount > 0 && rightCount > 0) {
                minMv = Math.max(minMv, Math.max(leftCount, rightCount));
            } else if (leftCount < 0 && rightCount < 0) {
                minMv = Math.max(minMv, -leftCount - rightCount);
            } else {
                minMv = Math.max(minMv, Math.max(Math.abs(leftCount), Math.abs(rightCount)));
            }
        }
        return minMv;
    }
}
