package org.whuims.leetcode.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(24, 40));
        System.out.println(myCalendarTwo.book(43, 50));
        System.out.println(myCalendarTwo.book(27, 43));
        System.out.println(myCalendarTwo.book(5, 21));
        System.out.println(myCalendarTwo.book(30, 40));
        System.out.println(myCalendarTwo.book(14, 29));
        System.out.println(myCalendarTwo.book(3, 19));
        System.out.println(myCalendarTwo.book(3, 14));
        System.out.println(myCalendarTwo.book(25, 39));
        System.out.println(myCalendarTwo.book(6, 19));
    }

    private List<int[]> books = new ArrayList<>();

    public MyCalendarTwo() {

    }

    public boolean book(int s, int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books)
            if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
        books.add(new int[]{s, e});
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();

        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{start, end});
            return true;
        }
    }
}
