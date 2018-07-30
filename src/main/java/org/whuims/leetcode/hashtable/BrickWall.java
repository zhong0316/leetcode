package org.whuims.leetcode.hashtable;

import java.util.*;

public class BrickWall {

    public static void main(String[] args) {
        BrickWall brickWall = new BrickWall();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(2, 4));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 3, 1, 1));
        int res = brickWall.leastBricks(wall);
        System.out.println(res);
    }

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        int res;
        int maxSofar = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        int m = wall.size();
        for (int i = 0; i < m; i++) {
            int total = 0;
            int n = wall.get(i).size();
            for (int j = 0; j < n - 1; j++) {
                total += wall.get(i).get(j);
                memo.put(total, memo.getOrDefault(total, 0) + 1);
                maxSofar = Math.max(maxSofar, memo.get(total));
            }
        }
        res = m - maxSofar;
        return res;
    }
}
