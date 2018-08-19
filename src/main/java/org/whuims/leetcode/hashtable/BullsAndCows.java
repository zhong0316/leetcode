package org.whuims.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();
        System.out.println(bullsAndCows.getHint("10", "11"));
    }

    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) {
            return "";
        }
        int bulls = 0, cows = 0;
        Map<Character, Integer> secretFreq = new HashMap<>();
        for (char c : secret.toCharArray()) {
            secretFreq.put(c, secretFreq.getOrDefault(c, 0) + 1);
        }
        Set<Integer> bullSet = new HashSet<>();
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (secret.charAt(i) == c) {
                bulls++;
                bullSet.add(i);
                secretFreq.put(c, secretFreq.get(c) - 1);
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (bullSet.contains(i)) {
                continue;
            }
            char c = guess.charAt(i);
            if (secretFreq.get(c) != null && secretFreq.get(c) > 0) {
                cows++;
                secretFreq.put(c, secretFreq.get(c) - 1);
            }
        }
        return bulls + "A" + cows + "B";
    }
}
