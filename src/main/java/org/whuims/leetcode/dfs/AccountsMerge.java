package org.whuims.leetcode.dfs;

import java.util.*;

public class AccountsMerge {

    public static void main(String[] args) {
        AccountsMerge accountsMerge = new AccountsMerge();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"), Arrays.asList("John", "johnnybravo@mail.com"), Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"), Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> res = accountsMerge.accountsMerge(accounts);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!map.containsKey(account.get(i))) {
                    map.put(account.get(i), new HashSet<>());
                }
                map.get(account.get(i)).add(account.get(1));
                map.get(account.get(1)).add(account.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        for (List<String> account : accounts) {
            if (!visited.contains(account.get(1))) {
                List<String> list = new ArrayList<>();
                bfs(map, account.get(1), visited, list);
                Collections.sort(list);
                list.add(0, account.get(0));
                res.add(list);
            }
        }
        return res;
    }

    private void bfs(Map<String, Set<String>> map, String s, Set<String> visited, List<String> list) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            String curt = queue.poll();
            list.add(curt);
            for (String nei : map.get(curt)) {
                if (!visited.contains(nei)) {
                    queue.offer(nei);
                    visited.add(nei);
                }
            }
        }
    }
}
