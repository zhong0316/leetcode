package org.whuims.leetcode.array;

public class ReshapeTheMatrix {

    public static void main(String[] args) {
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        int[][] nums = {{1,2},{3,4}};
        int[][] res = reshapeTheMatrix.matrixReshape(nums, 1, 4);
        System.out.println();
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            int originalRow = i / n;
            int originalCol = i % n;
            int newRow = i / c;
            int newCol = i % c;
            res[newRow][newCol] = nums[originalRow][originalCol];
        }
        return res;
    }
}
