package org.whuims.leetcode.array;

public class FibonacciNumber {

    public static void main(String[] args){
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        System.out.println(fibonacciNumber.fib(4));
    }

    public int fib(int N) {
        if (N == 0) return 0;
        int[] arr = new int[N + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N];
    }
}
