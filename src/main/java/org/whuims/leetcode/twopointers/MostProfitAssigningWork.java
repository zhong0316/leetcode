package org.whuims.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MostProfitAssigningWork {

    public static void main(String[] args) {
        MostProfitAssigningWork mostProfitAssigningWork = new MostProfitAssigningWork();
        int[] difficulty = {2, 4, 6, 8, 10}, profit = {10, 20, 30, 40, 50}, worker = {4, 5, 6, 7};
        int res = mostProfitAssigningWork.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(res);
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length, m = worker.length;
        int res = 0;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(difficulty[i], profit[i]);
            list.add(pair);
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.difficulty));
        for (int i = 0; i < m; i++) {
            int ability = worker[i];
            int maxLocal = 0;
            for (int j = 0; j < list.size(); j++) {
                Pair pair = list.get(j);
                if (pair.difficulty > ability) {
                    break;
                } else {
                    if (pair.profit > maxLocal) {
                        maxLocal = pair.profit;
                    }
                }
            }
            res += maxLocal;
        }
        return res;
    }

    class Pair {
        int difficulty;
        int profit;

        public Pair(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
