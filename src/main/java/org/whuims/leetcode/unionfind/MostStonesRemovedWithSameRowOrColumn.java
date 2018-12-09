package org.whuims.leetcode.unionfind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {

    public static void main(String[] args) {
        MostStonesRemovedWithSameRowOrColumn mostStonesRemovedWithSameRowOrColumn = new MostStonesRemovedWithSameRowOrColumn();
        int[][] stones = {{0, 1}, {1, 0}, {1, 1}};
        System.out.println(mostStonesRemovedWithSameRowOrColumn.removeStones(stones));
    }

//    /**
//     * union find，res就是stones - islands
//     *
//     * @param stones
//     * @return
//     */
//    public int removeStones(int[][] stones) {
//        int n = stones.length;
//        Map<Integer, Set<Integer>> rows = new HashMap<>();
//        Map<Integer, Set<Integer>> columns = new HashMap<>();
//        int id = 0;
//        for (int i = 0; i < n; i++) {
//            int[] stone = stones[i];
//            Set<Integer> set = rows.getOrDefault(stone[0], new HashSet<>());
//            set.add(i);
//            rows.put(stone[0], set);
//            set = columns.getOrDefault(stone[1], new HashSet<>());
//            set.add(i);
//            columns.put(stone[1], set);
//        }
//        Set<Integer> visited = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            if (!visited.contains(i)) {
//                dfs(rows, columns, i, visited, stones);
//                id++;
//            }
//        }
//        return n - id;
//    }
//
//    private void dfs(Map<Integer, Set<Integer>> rows, Map<Integer, Set<Integer>> columns, int curr, Set<Integer> visited, int[][] stones) {
//        if (visited.contains(curr)) {
//            return;
//        }
//        visited.add(curr);
//        Set<Integer> rowNeighbors = rows.get(stones[curr][0]);
//        for (Integer neighbor : rowNeighbors) {
//            dfs(rows, columns, neighbor, visited, stones);
//        }
//        Set<Integer> columnNeighbor = columns.get(stones[curr][1]);
//        for (Integer neighbor : columnNeighbor) {
//            dfs(rows, columns, neighbor, visited, stones);
//        }
//    }

    int[] parent = new int[1000];

    public int removeStones(int[][] stones) {
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    union(i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                counter++;
            }
        }
        return n - counter;
    }
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

}
