package org.whuims.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> res = partitionLabels.partitionLabels("ababcbacadefegdehijhklij");
        res.stream().forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String S) {
        if (S == null || S.length() == 0) {
            return null;
        }
        int len = S.length();
        int[] freq = new int[26];
        char[] ca = S.toCharArray();
        for (char c : ca) {
            freq[c - 'a']++;
        }
        int[] curr = new int[26];
        int i = 0;
        List<Integer> res = new ArrayList<>();
        int counter = 0;
        List<Character> currList = new ArrayList<>();
        while (i < len) {
            char c = ca[i];
            curr[c - 'a']++;
            currList.add(c);
            boolean allSame = true;
            for (char currChar : currList) {
                if (curr[currChar - 'a'] != 0 && freq[currChar - 'a'] != 0 &&
                        curr[currChar - 'a'] != freq[currChar - 'a']) {
                    allSame = false;
                    break;
                }
            }
            counter++;
            if (allSame) {
                res.add(counter);
                counter = 0;
                Arrays.fill(curr, 0);
            }
            i++;
        }
        return res;
    }
}
