package org.whuims.leetcode.dp;

import java.util.HashMap;

public class ArithmeticSlicesII {

    /**
     * 动态规划（Dynamic Programming）
     * <p>
     * 状态转移方程：dp[x][delta] += dp[y][delta] + 1（y∈[0, x - 1]）
     * dp[x][delta]表示以第x个元素结尾，且公差为delta的等差子序列切片个数。
     *
     * @param A
     * @return
     */
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[A.length];
        for (int i = 0; i < A.length; i++) {
            maps[i] = new HashMap<>();
            int num = A[i];
            for (int j = 0; j < i; j++) {
                if ((long) num - A[j] > Integer.MAX_VALUE) continue;
                if ((long) num - A[j] < Integer.MIN_VALUE) continue;
                int diff = num - A[j];
                int count = maps[j].getOrDefault(diff, 0);
                maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);
                res += count;
            }
        }
        return res;
    }
}
