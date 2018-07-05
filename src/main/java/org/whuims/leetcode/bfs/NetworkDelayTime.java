package org.whuims.leetcode.bfs;

import java.util.Arrays;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dis = new int[N];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[K] = 0;
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int[] time : times) {
                int u = time[0];
                int v = time[1];
                int cost = time[2];
                if (dis[u] != Integer.MAX_VALUE && dis[u] + cost < dis[v]) {
                    dis[v] = dis[u] + cost;
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if (i == K) {
                continue;
            }
            if (dis[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(dis[i], res);
        }
        return res;
    }
}
