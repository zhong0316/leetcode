package org.whuims.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ExamRoom {

    int N;
    private PriorityQueue<Interval> priorityQueue;

    public ExamRoom(int N) {
        this.N = N;
        priorityQueue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o2.dist != o1.dist ? o2.dist - o1.dist : o1.start - o2.start;
            }
        });
        priorityQueue.offer(new Interval(-1, N));
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
    }

    public int seat() {
        Interval interval = priorityQueue.poll();
        int seat;
        if (interval.start == -1) {
            seat = 0;
        } else if (interval.end == N) {
            seat = N - 1;
        } else {
            seat = (interval.start + interval.end) / 2;
        }
        priorityQueue.offer(new Interval(interval.start, seat));
        priorityQueue.offer(new Interval(seat, interval.end));
        return seat;
    }

    public void leave(int p) {
        List<Interval> list = new ArrayList<>(priorityQueue);
        Interval left = null, right = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).end == p) {
                left = list.get(i);
            }
            if (list.get(i).start == p) {
                right = list.get(i);
            }
            if (left != null && right != null) {
                break;
            }
        }
        priorityQueue.remove(left);
        priorityQueue.remove(right);
        priorityQueue.offer(new Interval(left.start, right.end));
    }

    class Interval {
        int start;
        int end;
        int dist;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
            if (start == -1) {
                dist = end;
            } else if (end == N) {
                dist = N - 1 - start;
            } else {
                dist = Math.abs(end - start) / 2;
            }
        }

    }
}
