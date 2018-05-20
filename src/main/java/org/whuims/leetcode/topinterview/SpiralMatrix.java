package org.whuims.leetcode.topinterview;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length, col = matrix[0].length;
        int startRow = 0, endRow = row - 1, startCol = 0, endCol = col - 1;
        int total = row * col, counter = 0;
        List<Integer> res = new ArrayList<>();
        while (counter < total && startRow <= endRow && startCol <= endCol) {
            // go right
            for (int i = startCol; i <= endCol; i++) {
                res.add(matrix[startRow][i]);
                counter++;
            }
            startRow++;
            if (counter < total) {
                // go down
                for (int i = startRow; i <= endRow; i++) {
                    res.add(matrix[i][endCol]);
                    counter++;
                }
                endCol--;
            }
            if (counter < total) {
                // go left
                for (int i = endCol; i >= startCol; i--) {
                    res.add(matrix[endRow][i]);
                    counter++;
                }
                endRow--;
            }
            if (counter < total) {
                // go up
                for (int i = endRow; i >= startRow; i--) {
                    res.add(matrix[i][startCol]);
                    counter++;
                }
                startCol++;
            }
        }
        return res;
    }
}
