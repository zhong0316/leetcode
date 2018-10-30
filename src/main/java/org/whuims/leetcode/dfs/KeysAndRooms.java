package org.whuims.leetcode.dfs;

import java.util.Arrays;
import java.util.List;

public class KeysAndRooms {

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
//        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(2,3), Arrays.asList(), Arrays.asList(2), Arrays.asList(1,3,1));
        List<List<Integer>> rooms = Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList());
        System.out.println(keysAndRooms.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        visited[0] = true;
        return canVisitAllRooms(visited, rooms, 0);
    }

    private boolean canVisitAllRooms(boolean[] visited, List<List<Integer>> rooms, int curr) {
        boolean allVisit = true;
        for (int i = 0; i < visited.length; i++) {
            allVisit &= visited[i];
        }
        if (allVisit) return true;
        List<Integer> keys = rooms.get(curr);
        for (int key : keys) {
            if (visited[key]) continue;
            visited[key] = true;
            if (canVisitAllRooms(visited, rooms, key)) return true;
        }
        return false;
    }
}
