package org.whuims.leetcode.dfs;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<String> res = reconstructItinerary.findItinerary(tickets);
        res.forEach(System.out::println);
    }

    public List<String> findItinerary(String[][] tickets) {
        if (tickets == null || tickets.length == 0) return new ArrayList<>();
        Map<Path, Integer> pathFreq = new HashMap<>();
        Map<String, Set<String>> edges = new HashMap<>();
        int n = tickets.length;
        for (String[] ticket : tickets) {
            Set<String> set = edges.getOrDefault(ticket[0], new TreeSet<>());
            set.add(ticket[1]);
            edges.put(ticket[0], set);
            Path path = new Path(ticket[0], ticket[1]);
            pathFreq.put(path, pathFreq.getOrDefault(path, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");
        dfs(edges, 0, n + 1, res, pathFreq, "JFK");
        return res;
    }

    private boolean dfs(Map<String, Set<String>> edges, int index, int n, List<String> res, Map<Path, Integer> pathFreq, String curr) {
        if (res.size() == n) return true;
        Set<String> candidate = edges.get(curr);
        if (candidate == null) {
            if (res.size() == n) return true;
            else return false;
        }
        for (String str : candidate) {
            Path path = new Path(curr, str);
            if (pathFreq.get(path) == 0) {
                continue;
            }
            res.add(str);
            pathFreq.put(path, pathFreq.get(path) - 1);
            if (dfs(edges, index + 1, n, res, pathFreq, str)) {
                return true;
            } else {
                res.remove(res.size() - 1);
                pathFreq.put(path, pathFreq.get(path) + 1);
            }
        }
        if (res.size() == n) return true;
        else return false;
    }

    class Path {
        String from, to;

        public Path(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return Objects.equals(from, path.from) &&
                    Objects.equals(to, path.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}
