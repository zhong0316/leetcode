package org.whuims.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundaryPaths {

    public static void main(String[] args) {
        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        long res = outOfBoundaryPaths.findPaths(1, 3, 3, 0, 1);
        System.out.println(res);
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    double modular = 1E9 + 7;
    Map<String, Integer> cache = new HashMap<>();

    public int findPaths(int m, int n, int N, int i, int j) {
        String key = m + "_" + n + "_" + N + "_" + i + "_" + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res;
        if (N >= 0 && isOutBoundary(m, n, i, j)) {
            res = 1;
        } else if (N < 0) {
            res = 0;
        } else {
            long temp = 0;
            for (int k = 0; k < 4; k++) {
                int di = i + dx[k];
                int dj = j + dy[k];
                temp += findPaths(m, n, N - 1, di, dj);
            }
            res = (int) (temp % modular);
        }
        cache.put(key, res);
        return res;
    }

    private boolean isOutBoundary(int m, int n, int i, int j) {
        return i < 0 || j < 0 || i >= m || j >= n;
    }
}
