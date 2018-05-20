package org.whuims.leetcode.topinterview;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long nume = Math.abs((long) numerator), deno = Math.abs((long) denominator);
        // integeral part
        long integeral = nume / deno;
        nume = nume % deno;
        sb.append(integeral);
        if (nume == 0) {
            return sb.toString();
        }
        Map<Long, Integer> map = new HashMap<>();
        sb.append(".");
        map.put(nume, sb.length());
        while (nume != 0) {
            nume *= 10;
            sb.append(nume / deno);
            nume %= deno;
            if (map.containsKey(nume)) {
                int index = map.get(nume);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(nume, sb.length());
            }
        }
        return sb.toString();
    }

}
