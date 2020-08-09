package org.whuims.leetcode2020.dp;

public class EditDistance {

    public static void main(String[] args) {
        String word1 = "e";
        String word2 = "execution";
        EditDistance e = new EditDistance();
        System.out.println(e.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j] : word[1:i] word2[1:j]
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = dp[i][j]; // 替换
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i + 1][j]); // 删除
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j + 1]); // 添加

                    dp[i + 1][j + 1]++;
                }
            }
        }

        return dp[m][n];
    }
}