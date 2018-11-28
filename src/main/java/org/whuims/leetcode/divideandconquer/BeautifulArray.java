package org.whuims.leetcode.divideandconquer;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {
    public static void main(String[] args){
        int[] res = new BeautifulArray().beautifulArray(5);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public int[] beautifulArray(int N) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (res.size() < N) {
            List<Integer> temp = new ArrayList<>();
            for (int i : res) {
                if (2 * i - 1 <= N) temp.add(2 * i - 1);
            }
            for (int i : res) {
                if (2 * i <= N) temp.add(2 * i);
            }
            res = temp;
        }
        int id = 0;
        int[] ret = new int[N];
        while (id < N) {
            ret[id] = res.get(id);
            id++;
        }
        return ret;
    }
}

