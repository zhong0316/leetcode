package org.whuims.leetcode.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public static void main(String[] args) {
        IsGraphBipartite isGraphBipartite = new IsGraphBipartite();
        int[][] graph = new int[][]{{3}, {2, 4}, {1}, {0, 4}, {1, 3}};
        boolean res = isGraphBipartite.isBipartite(graph);
        System.out.println(res);
    }

    public boolean isBipartite(int[][] graph) {
        // BFS
        // 0(not meet), 1(black), 2(white)
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0) {
                visited[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int current = q.poll();
                    for (int c : graph[current]) {
                        if (visited[c] == 0) {
                            visited[c] = (visited[current] == 1) ? 2 : 1;
                            q.offer(c);
                        } else {
                            if (visited[c] == visited[current]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
