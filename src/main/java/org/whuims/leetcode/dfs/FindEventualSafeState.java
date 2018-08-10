package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeState {

    public static void main(String[] args) {
        FindEventualSafeState findEventualSafeState = new FindEventualSafeState();
        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> res = findEventualSafeState.eventualSafeNodes(graph);
        res.stream().forEach(System.out::println);
    }

    //    // bfs
//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        Map<Integer, Set<Integer>> oGraph = new HashMap<>();
//        Map<Integer, Set<Integer>> rGraph = new HashMap<>();
//        Queue<Integer> queue = new LinkedList<>();
//        int n = graph.length;
//        for (int i = 0; i < n; i++) {
//            oGraph.put(i, new HashSet<>());
//            rGraph.put(i, new HashSet<>());
//        }
//        for (int i = 0; i < n; i++) {
//            int[] out = graph[i];
//            if (out.length == 0) {
//                queue.offer(i);
//            }
//            for (int j : out) {
//                oGraph.get(i).add(j);
//                rGraph.get(j).add(i);
//            }
//        }
//        boolean[] safe = new boolean[n];
//        while (!queue.isEmpty()) {
//            int vertex = queue.poll();
//            safe[vertex] = true;
//            for (int i : rGraph.get(vertex)) {
//                oGraph.get(i).remove(vertex);
//                if (oGraph.get(i).size() == 0) {
//                    queue.offer(i);
//                }
//            }
//        }
//        List<Integer> res = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (safe[i]) {
//                res.add(i);
//            }
//        }
//        return res;
//    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei : graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }

        color[node] = 2;
        return true;
    }
}
