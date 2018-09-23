package org.whuims.leetcode.math;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IntegerToRoman {

    public static void main(String[] args) {
        String res = new IntegerToRoman().intToRoman(3999);
        System.out.println(res);
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * IV:4, IX:9, XL:40, XC:90, CD:400, CM:900
     *
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        Map<Integer, String> map = new TreeMap<>((o1, o2) -> o2 - o1);
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        if (num < 1 || num > 3999) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            int time = num / key;
            for (int i = 0; i < time; i++) {
                stringBuilder.append(map.get(key));
            }
            num = num % key;
        }
        return stringBuilder.toString();
    }
}
