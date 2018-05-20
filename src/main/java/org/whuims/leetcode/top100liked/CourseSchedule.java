package org.whuims.leetcode.top100liked;

import java.util.*;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        boolean[] visit = new boolean[numCourses];
        int[] degreeIn = new int[numCourses + 1];
        List<int[]> vertices = new ArrayList<>();
        Map<Integer, List<int[]>> pos = new HashMap<>(16);
        Set<Integer> set = new HashSet<>(16);
        for (int i = 0; i < prerequisites.length; i++) {
            int[] nums = prerequisites[i];
            set.add(nums[0]);
            set.add(nums[1]);
            if (pos.containsKey(nums[1])) {
                List<int[]> temp = pos.get(nums[1]);
                if (temp == null) {
                    temp = new ArrayList<>();
                }
                temp.add(nums);
                pos.put(nums[1], temp);
            } else {
                List<int[]> temp = new ArrayList<>();
                temp.add(nums);
                pos.put(nums[1], temp);
            }
            vertices.add(nums);
            degreeIn[nums[0]] += 1;
        }
        while (vertices.size() > 0) {
            for (int[] vertice : vertices) {
                if (visit[vertice[0]]) {
                    return false;
                }
            }
            int head = findZeroDegreeIn(degreeIn, numCourses, set);
            if (head == -1) {
                return false;
            }
            List<int[]> lis = pos.get(head);
            if (lis != null) {
                for (int[] vertice : lis) {
                    degreeIn[vertice[0]] -= 1;
                }
                vertices.removeAll(lis);
            }
            visit[head] = true;
            set.remove(head);
        }
        return true;
    }

    private int findZeroDegreeIn(int[] degreeIn, int num, Set<Integer> set) {
        for (int i = 0; i < num; i++) {
            if (degreeIn[i] == 0 && set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
