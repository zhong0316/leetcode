package org.whuims.leetcode.topinterview;

public class HappyNumber {

    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n = n / 10;
            }
            n = sum;
        }
        return n == 1 ? true : false;
    }
}
