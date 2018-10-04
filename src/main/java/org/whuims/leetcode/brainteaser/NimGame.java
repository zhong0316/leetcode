package org.whuims.leetcode.brainteaser;

public class NimGame {

    public static void main(String[] args) {
        System.out.println(new NimGame().canWinNim(5));
    }

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
