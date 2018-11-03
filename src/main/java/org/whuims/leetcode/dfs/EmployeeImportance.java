package org.whuims.leetcode.dfs;

import java.util.List;

public class EmployeeImportance {

    public int getImportance(List<Employee> employees, int id) {
        boolean[] visited = new boolean[2001];
        return dfs(id, employees, visited);
    }

    private int dfs(int id, List<Employee> employees, boolean[] visited) {
        if (visited[id]) return 0;
        Employee self = null;
        for (Employee employee : employees) {
            if (employee.id == id) {
                self = employee;
                break;
            }
        }
        int res = self.importance;
        visited[id] = true;
        List<Integer> subordinates = self.subordinates;
        for (int subordinate : subordinates) res += dfs(subordinate, employees, visited);
        return res;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
