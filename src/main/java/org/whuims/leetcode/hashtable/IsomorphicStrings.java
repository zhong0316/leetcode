package org.whuims.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s == null) return t == null;
        if (s.length() == 0) return t.length() == 0;
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> reverseMap = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) return false;
            if (reverseMap.containsKey(c2) && reverseMap.get(c2) != c1) return false;
            if (c1 != c2) {
                if (set.contains(c1) || set.contains(c2)) return false;
                map.put(c1, c2);
                reverseMap.put(c2, c1);
            } else set.add(c1);
        }
        return true;
    }
}
