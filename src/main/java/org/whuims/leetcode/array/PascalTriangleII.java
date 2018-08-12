package org.whuims.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {
        PascalTriangleII pascalTriangleII = new PascalTriangleII();
        List<Integer> res = pascalTriangleII.getRow(4);
        res.forEach(System.out::println);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}
