package org.whuims.leetcode.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{{0, 1, 100}, {0, 2, 500}, {1, 2, 200}};
        int res = cheapestFlightsWithinKStops.findCheapestPrice(3, flights, 0, 2, 0);
        System.out.println(res);
    }

    // bfs
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int[][] adj = new int[n][n];
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int fee = flight[2];
            adj[u][v] = fee;
        }
        Queue<Integer> cities = new LinkedList<>();
        cities.add(src);
        minCost[src] = 0;
        while (K >= 0 && !cities.isEmpty()) {
            int size = cities.size();
            for (int i = 0; i < size; i++) {
                int currCity = cities.poll();
                for (int[] flight : flights) {
                    int u = flight[0];
                    int v = flight[1];
                    if (currCity == u && minCost[v] > minCost[u] + adj[u][v]) {
                        minCost[v] = minCost[u] + adj[u][v];
                        cities.add(v);
                    }
                }
            }
            K--;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
