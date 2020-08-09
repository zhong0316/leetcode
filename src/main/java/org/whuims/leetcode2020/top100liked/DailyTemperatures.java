package org.whuims.leetcode2020.top100liked;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures d = new DailyTemperatures();
        int[] T = {};
        int[] res = d.dailyTemperatures(T);
        System.out.println(res.length);
    }

    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (res[i] == -1) {
                res[i] = 0;
            }
        }
        return res;
    }
}