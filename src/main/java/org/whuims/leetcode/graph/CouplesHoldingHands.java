package org.whuims.leetcode.graph;

public class CouplesHoldingHands {

//    // greedy algorithm
//    public int minSwapsCouples(int[] row) {
//        int n = row.length;
//        int res = 0;
//        for (int i = 0; i < n; i += 2) {
//            if (row[i] == (row[i + 1] ^  1)) continue;
//            res++;
//            for (int j = i + 1; j < n; j++) {
//                if (row[j] == (row[i] ^ 1)) {
//                    int temp = row[j];
//                    row[j] = row[i + 1];
//                    row[i + 1] = temp;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    public static void main(String[] args) {
        CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands();
        int[] row = {0,2,1,3};
        System.out.println(couplesHoldingHands.minSwapsCouples(row));
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] root = new int[n / 2];
        int count = n / 2;
        for (int i = 0; i < n / 2; i++) root[i] = i;
        for (int i = 0; i < n; i += 2) {
            int x = find(root, row[i] / 2), y = find(root, row[i + 1] / 2);
            if (x != y) {
                root[x] = y;
                count--;
            }
        }
        return n / 2 - count;
    }

    private int find(int[] root, int i) {
        if (i == root[i]) return i;
        else return find(root, root[i]);
    }
}
