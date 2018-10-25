package org.whuims.leetcode.array;

import java.util.TreeMap;

public class MyCalendarI {

    TreeMap<Integer, Integer> treeMap;

    public MyCalendarI() {
        treeMap = new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendarI myCalendarI = new MyCalendarI();
        System.out.println(myCalendarI.book(47, 50));
        System.out.println(myCalendarI.book(33, 41));
        System.out.println(myCalendarI.book(39, 45));
        System.out.println(myCalendarI.book(33, 42));
        System.out.println(myCalendarI.book(25, 32));
        System.out.println(myCalendarI.book(26, 35));
        System.out.println(myCalendarI.book(19, 25));
        System.out.println(myCalendarI.book(3, 8));
        System.out.println(myCalendarI.book(8, 13));
        System.out.println(myCalendarI.book(18, 27));
    }

    public boolean book(int start, int end) {
        Integer floorKey = treeMap.floorKey(start);
        if (floorKey != null && treeMap.get(floorKey) > start) return false;
        Integer ceilingKey = treeMap.ceilingKey(start);
        if (ceilingKey != null && ceilingKey < end) return false;
        treeMap.put(start, end);
        return true;
    }
}
