package org.whuims.leetcode.backtracking;

import java.util.ArrayList;

public class GrayCode {

    /**
     * gray code中文名叫格雷码，一看题就知道是模拟类型，写几个例子出来找规律。
     * 以3位格雷码为例。
     * 0 0 0
     * 0 0 1
     * 0 1 1
     * 0 1 0
     * 1 1 0
     * 1 1 1
     * 1 0 1
     * 1 0 0
     * 可以看到第n位的格雷码由两部分构成，一部分是n-1位格雷码，再加上 1<<(n-1)和n-1位格雷码的逆序的和。
     * @param n
     * @return
     */
    public ArrayList<Integer> grayCode(int n) {
        if (n == 0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> tmp = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        ArrayList<Integer> result = new ArrayList<>(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}
