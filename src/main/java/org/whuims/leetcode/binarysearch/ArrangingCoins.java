package org.whuims.leetcode.binarysearch;

public class ArrangingCoins {

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int res = arrangingCoins.arrangeCoins(1804289383);
        System.out.println(res);
    }

    public int arrangeCoins(int n) {
        return (int) (Math.sqrt(2) * Math.sqrt(n + 0.125) - 0.5);
    }
}
