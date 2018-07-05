package org.whuims.leetcode.dfs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public static void main(String[] args) {
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int[][] times = {{1, 2, 2}, {2, 3, 3}, {3, 2, 4}, {2, 1, 2}};
        int res = networkDelayTime.networkDelayTime(times, 3, 3);
        System.out.println(res);
    }

    // Dijkstra's Algorithm
    public int networkDelayTime(int[][] times, int N, int K) {
        //construct directed graph.
        int[][] graph = new int[N + 1][N + 1];
        for (int[] row : graph) {
            // in some cases distance between 2 nodes is 0(wtf), so we have to initialize it to negative number
            Arrays.fill(row, -1);
        }
        for (int[] t : times) {
            graph[t[0]][t[1]] = t[2];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        boolean[] visited = new boolean[N + 1];
        // nodes number starts from 0 to N.
        visited[0] = true;
        visited[K] = true;
        for (int i = 0; i < N + 1; i++) {
            if (graph[K][i] >= 0) {
                // int[] {index0: target, index1: how far we already travelled from K to this node.}
                pq.offer(new int[]{i, graph[K][i]});
            }
        }
        // final answer
        int max = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int target = cur[0];
            if (visited[target]) {
                continue;
            }
            max = Math.max(cur[1], max);
            visited[target] = true;
            for (int i = 0; i < N + 1; i++) {
                if (graph[target][i] >= 0 && !visited[i]) {
                    pq.offer(new int[]{i, cur[1] + graph[target][i]});
                }
            }
        }
        // to check if we already visited all the nodes.
        for (boolean i : visited) {
            if (!i) {
                return -1;
            }
        }
        return max;
    }
}
