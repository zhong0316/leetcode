package org.whuims.leetcode.string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

    public static void main(String[] args) throws IOException {
        WordSubsets wordSubsets = new WordSubsets();
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"ec", "oc", "ceo"};
        List<String> res = wordSubsets.wordSubsets(A, B);
        for (String str : res) {
            System.out.println(str);
        }
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        List<int[]> aFreq = new ArrayList<>();
        int[] bFreq = new int[26];
        for (int i = 0; i < A.length; i++) {
            String str = A[i];
            int[] freq = new int[26];
            for (int j = 0; j < str.length(); j++) {
                freq[str.charAt(j) - 'a']++;
            }
            aFreq.add(freq);
        }
        for (int i = 0; i < B.length; i++) {
            String str = B[i];
            int[] freq = new int[26];
            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                freq[index]++;
                if (freq[index] > bFreq[index]) bFreq[index] = freq[index];
            }
        }
        List<String> res = new ArrayList<>();
        for (int j = 0; j < A.length; j++) {
            if (match(aFreq.get(j), bFreq)) {
                res.add(A[j]);
            }
        }
        return res;
    }

    private boolean match(int[] aFreq, int[] bFreq) {
        for (int i = 0; i < bFreq.length; i++) {
            if (bFreq[i] > aFreq[i]) return false;
        }
        return true;
    }
}
