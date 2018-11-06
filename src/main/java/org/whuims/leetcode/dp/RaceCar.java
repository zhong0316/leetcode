package org.whuims.leetcode.dp;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RaceCar {

    public static void main(String[] args) {
        RaceCar raceCar = new RaceCar();
        long start = System.currentTimeMillis();
        System.out.println(raceCar.racecar(10000));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

//    /**
//     * bfs time : O(2 ^ n), space : O(2 ^ n)
//     *
//     * @param target
//     * @return
//     */
//    public int racecar(int target) {
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{0, 1});
//        Set<String> visited = new HashSet<>();
//        visited.add(0 + "_" + 1);
//        int level = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int[] curr = queue.poll();
//                if (curr[0] == target) {
//                    return level;
//                }
//                // accelerate
//                int[] next = new int[]{curr[0] + curr[1], curr[1] << 1};
//                String key = next[0] + "_" + next[1];
//                if (!visited.contains(key) && next[0] > 0 && next[0] < (target << 1)) {
//                    queue.offer(next);
//                    visited.add(key);
//                }
//                // reverse
//                next = new int[]{curr[0], curr[1] > 0 ? -1 : 1};
//                key = next[0] + "_" + next[1];
//                if (!visited.contains(key) && next[0] > 0 && next[0] < (target << 1)) {
//                    queue.offer(next);
//                    visited.add(key);
//                }
//            }
//            level++;
//        }
//        return -1;
//    }

    /**
     * For the input 5, we can reach with only 7 steps: AARARAA. Because we can step back.
     *
     * Let's say n is the length of target in binary and we have 2 ^ (n - 1) <= target < 2 ^ n
     * We have 2 strategies here:
     * 1. Go pass our target , stop and turn back
     * We take n instructions of A.
     * 1 + 2 + 4 + ... + 2 ^ (n-1) = 2 ^ n - 1
     * Then we turn back by one R instruction.
     * In the end, we get closer by n + 1 instructions.
     *
     * 2. Go as far as possible before pass target, stop and turn back
     * We take N - 1 instruction of A and one R.
     * Then we take m instructions of A, where m < n
     */
    int[] dp = new int[10001];

    public int racecar(int t) {
        if (dp[t] > 0) return dp[t];
        int n = (int)(Math.log(t) / Math.log(2)) + 1;
        if (1 << n == t + 1) {
            dp[t] = n;
        } else {
            dp[t] = racecar((1 << n) - 1 - t) + n + 1;
            // 先走n-1步，(指令数：n - 1)，再掉头(指令数:n)，反方向走m步（0 <= m <= n - 2）（指令数：n + m），再掉头走，指令数
            // （n + m + 1），再递归racecar(t - (1 << (n - 1)) + (1 << m))
            for (int m = 0; m < n - 1; ++m) {
                dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
            }
        }
        return dp[t];
    }
}
