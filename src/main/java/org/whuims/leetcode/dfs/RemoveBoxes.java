package org.whuims.leetcode.dfs;

public class RemoveBoxes {

    public static void main(String[] args) {
        RemoveBoxes removeBoxes = new RemoveBoxes();
        int[] boxes = {3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7};
        System.out.println(removeBoxes.removeBoxes(boxes));
    }

    /**
     * 我们的dp数组应该是一个三维数组dp[i][j][k]，表示区间[i, j]中能获得的最大积分，当boxes[i]左边有k个数字跟其相等，
     * 那么我们的目标就是要求dp[0][n-1][0]了，而且我们也能推出dp[i][i][k] = (1+k) * (1+k)这个等式。那么我们来推导重现关系，
     * 对于dp[i][j][k]，如果我们移除boxes[i]，那么我们得到(1+k)*(1+k) + dp[i+1][j][0]。对于上面提到的那种情况，
     * 当某个位置m，有boxes[i] == boxes[m]时，我们也应该考虑先移除[i+1,m-1]这部分，我们得到积分dp[i+1][m-1][0]，
     * 然后再处理剩下的部分，得到积分dp[m][j][k+1]，这里k加1点原因是，移除了中间的部分后，原本和boxes[m]不相邻的boxes[i]现在相邻了，
     * 又因为二者值相同，所以k应该加1，因为k的定义就是左边相等的数字的个数。
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // dp[i][j][k]，boxes[i, j]，i左边有k个数字等于boxes[i]的最高得分
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        // optimization: all boxes of the same color counted continuously from the first box should be grouped together
        for (; i + 1 <= j && boxes[i + 1] == boxes[i]; i++, k++);
        int res = (1 + k) * (1 + k) + removeBoxesSub(boxes, i + 1, j, 0, dp);
        for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
