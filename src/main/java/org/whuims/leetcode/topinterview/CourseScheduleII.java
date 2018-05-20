package org.whuims.leetcode.topinterview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        // compute indegree
        int n = prerequisites.length;
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] edge = prerequisites[i];
            int next = edge[0];
            int now = edge[1];
            indegree[next]++;
            if (nextMap.containsKey(now)) {
                List<Integer> lis = nextMap.get(now);
                lis.add(next);
                nextMap.put(now, lis);
            } else {
                List<Integer> lis = new ArrayList<>();
                lis.add(next);
                nextMap.put(now, lis);
            }
        }
        List<Integer> zeroDegree = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                zeroDegree.add(i);
            }
        }
        int[] res = new int[numCourses];
        while (true) {
            if (zeroDegree.size() == 0 && counter < numCourses) {
                return new int[0];
            }
            if (counter >= numCourses && zeroDegree.size() == 0) {
                break;
            }
            List<Integer> nextZeroIndegree = new ArrayList<>();
            for (int index : zeroDegree) {
                res[counter++] = index;
                indegree[index]--;
                List<Integer> nextCourses = nextMap.get(index);
                if (nextCourses == null) {
                    continue;
                }
                for (int nextCourse : nextCourses) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        nextZeroIndegree.add(nextCourse);
                    }
                }
            }
            zeroDegree.clear();
            zeroDegree.addAll(nextZeroIndegree);
        }
        return res;
    }
}
