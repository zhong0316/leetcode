package org.whuims.leetcode.array;

public class TeemoAttacking {

    public static void main(String[] args) {
        TeemoAttacking teemoAttacking = new TeemoAttacking();
        int[] timeSeries = {1, 2, 3, 4, 5};
        int res = teemoAttacking.findPoisonedDuration(timeSeries, 5);
        System.out.println(res);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        int res;
        int n = timeSeries.length;
        res = timeSeries[n - 1] + duration - timeSeries[0];
        for (int i = 0; i < n - 1; i++) {
            int curr = timeSeries[i];
            int next = timeSeries[i + 1];
            if (curr + duration < next) {
                res += curr + duration - next;
            }
        }
        return res;
    }
}
