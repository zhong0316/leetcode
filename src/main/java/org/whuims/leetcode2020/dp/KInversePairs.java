package org.whuims.leetcode2020.dp;

/**
 * Given two integers n and k, find how many different arrays consist of numbers
 * from 1 to n such that there are exactly k inverse pairs.
 * 
 * We define an inverse pair as following: For ith and jth element in the array,
 * if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 * 
 * Since the answer may be very large, the answer should be modulo 109 + 7.
 * 
 * Example 1:
 * 
 * Input: n = 3, k = 0 Output: 1 Explanation: Only the array [1,2,3] which
 * consists of numbers from 1 to 3 has exactly 0 inverse pair.
 * 
 * 
 * Example 2:
 * 
 * Input: n = 3, k = 1 Output: 2 Explanation: The array [1,3,2] and [2,1,3] have
 * exactly 1 inverse pair.
 * 
 * 
 * Note:
 * 
 * The integer n is in the range [1, 1000] and k is in the range [0, 1000].
 * 
 */
public class KInversePairs {

    public static void main(String[] args) {
        KInversePairs k = new KInversePairs();
        System.out.println(k.kInversePairs(3, 1));

    }

    // dp[n][k]：[1,n]数组中k对逆序对的排序方式
    /**
     * Analysis:
     * 
     * For example, if we have some permutation of 1 ..... 4
     * 
     * 5 * * * * creates 4 new inverse pairs
     * 
     * 5 * * * creates 3 new inverse pairs
     * 
     * * 5 * * creates 2 new inverse pairs
     * 
     * * * 5 * creates 1 new inverse pairs
     * 
     * * * * 5 creates 0 new inverse pairs
     * 
     * 
     * 
     * We can use this formula to solve this problem
     * 
     * 
     * 
     * dp[i][j] : represent the number of permutations of (1 ... n) with k inverse
     * pairs.
     * 
     * dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + dp[i-1][j-2] + ..... + dp[i-1][j-i+1]
     * 对应： ****5 **5* *5** 5****
     * 
     * dp[i][j +1] = dp[i][j + 1] + dp[i - 1][j] + dp[i -1][j - 1] + ... + dp[i -
     * 1][j-i+2];
     * 
     * 两边相减得到 dp[i][j + 1] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - i + 1];
     * 
     * @param n
     * @param k
     * @return
     */
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        long[][] dp = new long[n + 1][k + 1];
        if (k > n * (n - 1) / 2 || k < 0) {
            return 0;
        }

        if (k == n * (n - 1) / 2) {
            return 1;
        }
        dp[2][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, n * (n - 1) / 2); j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i] + mod;
                }
                dp[i][j] %= mod;
            }
        }
        return (int) dp[n][k];
    }
}