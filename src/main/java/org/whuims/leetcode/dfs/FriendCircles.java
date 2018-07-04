package org.whuims.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FriendCircles {

    public static void main(String[] args) {
        FriendCircles friendCircles = new FriendCircles();
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int res = friendCircles.findCircleNum(M);
        System.out.println(res);
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int res = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visit[i]) {
                continue;
            }
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int k = queue.poll();
                if (visit[k]) {
                    continue;
                }
                visit[k] = true;
                List<Integer> neighbors = getNeighbors(M, k);
                queue.addAll(neighbors);
            }
            res++;
        }
        return res;
    }

    private List<Integer> getNeighbors(int[][] M, int i) {
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < M.length; j++) {
            if (j == i) {
                continue;
            }
            if (M[i][j] == 1) {
                res.add(j);
            }
        }
        return res;
    }
}
