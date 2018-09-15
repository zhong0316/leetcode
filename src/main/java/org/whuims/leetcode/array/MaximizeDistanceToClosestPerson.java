package org.whuims.leetcode.array;

public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = new MaximizeDistanceToClosestPerson();
        int[] seats = {0, 0, 0, 0, 1};
        int res = maximizeDistanceToClosestPerson.maxDistToClosest(seats);
        System.out.println(res);
    }

    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) {
            return 0;
        }
        int len = seats.length;
        int left = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) continue;
            if (seats[i] == -1) {
                res = Math.max(res, i);
            } else {
                res = Math.max(res, (i - left) / 2);
            }
            left = i;
        }
        if (seats[len - 1] == 0) {
            res = Math.max(res, len - left - 1);
        }
        return res;
    }
}
