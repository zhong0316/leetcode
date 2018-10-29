package org.whuims.leetcode.stack;

import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision asteroidCollision = new AsteroidCollision();
//        int[] asteroids = new int[]{10, 2, -5};
//        int[] asteroids = new int[]{5, 10, -5};
        int[] asteroids = new int[]{1, 1, -2, -2, -2};
//        int[] asteroids = new int[]{-2, -1, 1, 2};
        int[] res = asteroidCollision.asteroidCollision(asteroids);
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 2) return asteroids;
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int asteroid = asteroids[i];
            if (asteroid < 0) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.add(asteroid);
                } else {
                    while (!stack.isEmpty()) {
                        if (stack.peek() + asteroid > 0) break;
                        else if (stack.peek() + asteroid == 0) {
                            stack.pop();
                            break;
                        } else {
                            if (stack.peek() > 0) {
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.add(asteroid);
                                    break;
                                }
                            } else {
                                stack.add(asteroid);
                                break;
                            }
                        }
                    }
                }
            } else stack.add(asteroid);
        }
        int resLen = stack.size();
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) res[resLen - i++ - 1] = stack.pop();
        return res;
    }
}
