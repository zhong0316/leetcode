package org.whuims.leetcode.dfs;

import java.util.HashMap;
import java.util.Map;

public class ZumaGame {

    public static void main(String[] args) {
        ZumaGame zumaGame = new ZumaGame();
        System.out.println(zumaGame.findMinStep("WWRRBBWW", "WRBRW"));
    }

    private static final int MAX_STEP = 6;

    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handFreq = new HashMap<>();
        for (int i = 0; i < hand.length(); i++) {
            handFreq.put(hand.charAt(i), handFreq.getOrDefault(hand.charAt(i), 0) + 1);
        }
        int res = findMinStep(board + "#", handFreq);
        return res == MAX_STEP ? -1 : res;
    }

    private int findMinStep(String board, Map<Character, Integer> handFreq) {
        board = removeConsecutive(board);
        if (board.equals("#")) return 0;
        int res = MAX_STEP;
        int i = 0, j = 0;
        while (i < board.length() && j < board.length()) {
            char curr = board.charAt(i);
            while (j < board.length() && board.charAt(j) == curr) j++;
            int need = 3 - (j - i);
            if (handFreq.get(curr) != null && handFreq.get(curr) >= need) {
                int has = handFreq.get(curr);
                handFreq.put(curr, has - need);
                res = Math.min(res, need + findMinStep(board.substring(0, i) + board.substring(j), handFreq));
                handFreq.put(curr, has);
            }
            i = j;
        }
        return res;
    }

    private String removeConsecutive(String s) {
        int i = 0, j = 0;
        while (j < s.length()) {
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            if (j - i >= 3) {
                return removeConsecutive(s.substring(0, i) + s.substring(j));
            }
            i = j;
        }
        return s;
    }
}
