package org.whuims.leetcode.greedy;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int[] people = {1,2};
        int limit = 3;
        System.out.println(boatsToSavePeople.numRescueBoats(people, limit));
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int left = 0, right = n - 1;
        int res = n;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                res--;
                left++;
                right--;
            } else {
                right--;
            }
        }
        return res;
    }
}
