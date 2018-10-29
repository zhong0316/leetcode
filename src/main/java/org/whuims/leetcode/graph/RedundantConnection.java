package org.whuims.leetcode.graph;

import java.util.*;

public class RedundantConnection {

    public static void main(String[] args) {
        RedundantConnection redundantConnection = new RedundantConnection();
//        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[][] edges = {{2,7},{7,8},{3,6},{2,5},{6,8},{4,8},{2,8},{1,8},{7,10},{3,9}};
        int[] res = redundantConnection.findRedundantConnection(edges);
        System.out.println(res[0] + " " + res[1]);
    }

//    public int[] findRedundantConnection(int[][] edges) {
//        if (edges == null || edges.length == 0) return new int[]{};
//        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
//        for (int[] edge : edges) {
//            int source = edge[0], target = edge[1];
//            Set<Integer> sourceNei = neighbors.getOrDefault(source, new HashSet<>());
//            Set<Integer> targetNei = neighbors.getOrDefault(target, new HashSet<>());
//            sourceNei.add(target);
//            targetNei.add(source);
//            neighbors.put(source, sourceNei);
//            neighbors.put(target, targetNei);
//        }
//        Map<Integer, Boolean> visited = new HashMap<>();
//        for (Integer vertice : neighbors.keySet()) visited.put(vertice, false);
//        for (Integer vertice : neighbors.keySet()) {
//            List<Integer> path = new ArrayList<>();
//            if (dfs(neighbors, path, visited, vertice, vertice)) {
//                for (int i = edges.length - 1; i >= 0; --i) {
//                    int[] edge = edges[i];
//                    if (path.contains(edge[0]) && path.contains(edge[1])) return edge;
//                }
//                break;
//            }
//        }
//        return null;
//    }
//
//    private boolean dfs(Map<Integer, Set<Integer>> neighborsMap, List<Integer> path, Map<Integer, Boolean> visited, int curr, int source) {
//        visited.put(curr, true);
//        path.add(curr);
//        Set<Integer> neighbors = neighborsMap.get(curr);
//        if (path.size() > 2 && neighbors.contains(source)) {
//            return true;
//        }
//        for (Integer neighbor : neighbors) {
//            if (visited.get(neighbor)) continue;
//            if (dfs(neighborsMap, path, visited, neighbor, source)) return true;
//        }
//        path.remove(path.size() - 1);
//        visited.put(curr, false);
//        return false;
//    }

    public int[] findRedundantConnection(int[][] edges) {
        int[] root = new int[2001];
        for (int i = 1; i < 2001; i++) root[i] = i;
        for (int[] edge : edges) {
            int x = find(root, edge[0]), y = find(root, edge[1]);
            if (x == y) return edge;
            else root[x] = y;
        }
        return new int[2];
    }

    private int find(int[] root, int i) {
        if (root[i] == i) return i;
        else return find(root, root[i]);
    }
}
