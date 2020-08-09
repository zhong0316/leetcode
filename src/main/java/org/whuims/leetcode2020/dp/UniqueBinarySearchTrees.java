package org.whuims.leetcode2020.dp;

public class UniqueBinarySearchTrees {
    
    public static void main(String[] args) {
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(5));
    }

    public int numTrees(int n) {
        // G(i) 1...i为节点组成的二叉树个数
        // f(i, n) 以i为根结点的二叉树个数（总共n个节点）
        // G(n) = f(1) + f(2) + ... + f(n)
        // f(i) = G(i - 1) * G(n - i)
        // G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }

        return dp[n];
    }
}