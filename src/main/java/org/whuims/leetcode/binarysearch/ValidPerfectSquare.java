package org.whuims.leetcode.binarysearch;

public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare(808201));
    }

    /**
     * binarySearch完全平方数
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 2) {
            return true;
        }
        int low = 1, high = num / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
