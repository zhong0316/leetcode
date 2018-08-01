package org.whuims.leetcode.math;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        boolean res = sumOfSquareNumbers.judgeSquareSum(10);
        System.out.println(res);
    }

    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
