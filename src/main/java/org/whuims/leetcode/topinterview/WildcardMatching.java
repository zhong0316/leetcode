package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("", "*"));
    }

    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0) {
            return p == null || p.length() == 0 || p.replaceAll("\\*", "").length() == 0;
        }
        return matchBacktracking(s.toCharArray(), p.toCharArray(), 0, 0, new HashMap<>());
    }

    private boolean matchBacktracking(char[] sc, char[] pc, int i, int j, Map<String, Boolean> cache) {
        String key = i + "_" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (i == sc.length && j == pc.length) {
            cache.put(key, true);
            return true;
        }
        if (j == pc.length) {
            cache.put(key, false);
            return false;
        }
        if (i < sc.length && j < pc.length && pc[j] >= 'a' && pc[j] <= 'z' && sc[i] != pc[j]) {
            cache.put(key, false);
            return false;
        }
        boolean res = false;
        if (pc[j] == '?' && i < sc.length && j < pc.length) {
            res = matchBacktracking(sc, pc, i + 1, j + 1, cache);
        } else if (pc[j] == '*') {
            if (j < pc.length) {
                res = res || matchBacktracking(sc, pc, i, j + 1, cache);
            }
            if (i < sc.length) {
                res = res || matchBacktracking(sc, pc, i + 1, j, cache);
            }
        } else {
            if (i < sc.length && j < pc.length && sc[i] == pc[j]) {
                res = matchBacktracking(sc, pc, i + 1, j + 1, cache);
            }
        }
        cache.put(key, res);
        return res;
    }
}
