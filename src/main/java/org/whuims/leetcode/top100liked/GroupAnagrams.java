package org.whuims.leetcode.top100liked;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null) {
            return res;
        }
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> tempMap = new HashMap<>();
            char[] cs = str.toCharArray();
            for (char c : cs) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            if (map.containsKey(tempMap)) {
                List<String> listStr = map.get(tempMap);
                listStr.add(str);
                map.put(tempMap, listStr);
            } else {
                List<String> listStr = new ArrayList<>();
                listStr.add(str);
                map.put(tempMap, listStr);
            }
        }
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}
