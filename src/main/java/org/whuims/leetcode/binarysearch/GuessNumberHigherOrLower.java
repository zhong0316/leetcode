package org.whuims.leetcode.binarysearch;

public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = guess(mid);
            if (cmp < 0) {
                high = mid - 1;
            } else if (cmp > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return 0;
    }
}
