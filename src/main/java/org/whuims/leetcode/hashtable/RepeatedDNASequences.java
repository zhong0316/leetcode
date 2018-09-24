package org.whuims.leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

    public static void main(String[] args) {
        RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
        List<String> res = repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        res.forEach(System.out::println);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 10) {
            return res;
        }
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String temp = s.substring(i, i + 10);
            if (set.contains(temp) && !res.contains(temp)) {
                res.add(temp);
            }
            set.add(temp);
        }
        return res;
    }
}
