package org.whuims.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[5];
        int[] arr = new int[]{1,2,3,4,5};
        permutations.backtracking(arr, 0, visit, res, new ArrayList<>());
        for (List<Integer> list : res) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private void backtracking(int[] arr, int counter, boolean[] visit, List<List<Integer>> res, List<Integer> curr) {
        if (counter == arr.length) {
            res.add(new ArrayList<>(curr));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (visit[i]) {
                    continue;
                }
                visit[i] = true;
                counter++;
                curr.add(arr[i]);
                backtracking(arr, counter, visit, res, curr);
                curr.remove(curr.size() - 1);
                counter--;
                visit[i] = false;
            }
        }
    }
}
