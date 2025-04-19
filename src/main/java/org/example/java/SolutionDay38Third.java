package org.example.java;

import java.util.Arrays;

//    hard. Really HARD #dynamic programming with 3D array. Tabulation approach.
//    Spent half a day to understand solution of another person and rewrite by myself
//    https://leetcode.com/problems/build-array-where-you-can-find-the-maximum-exactly-k-comparisons
//    You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array
//    of positive integers:
//    You should build the array arr which has the following properties:
//    arr has exactly n integers.
//    1 <= arr[i] <= m where (0 <= i < n).
//    After applying the mentioned algorithm to arr, the value search_cost is equal to k.
//    Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large,
//    the answer must be computed modulo 109 + 7.
//    Example 1:
//    Input: n = 2, m = 3, k = 1
//    Output: 6
//    Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
//    Example 2:
//    Input: n = 5, m = 2, k = 3
//    Output: 0
//    Explanation: There are no possible arrays that satisfy the mentioned conditions.
//    Example 3:
//    Input: n = 9, m = 1, k = 1
//    Output: 1
//    Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
public class SolutionDay38Third {
    public static int numOfArrays(int n, int m, int k) {
        int mod = 1000000007;
        long ans = 0;
        long[][][] dp = new long[n][k][m];
        Arrays.fill(dp[0][0], 1);
        for (int i = 1; i < n; i++) {
            //cost can't be bigger than array size (i+1)
            for (int cost = 0; cost < Math.min(k, i + 1); cost++) {
                for (int j = 0; j < m; j++) {
                    dp[i][cost][j] = (dp[i][cost][j] + ((j + 1) * dp[i - 1][cost][j]) % mod) % mod;
                    if (cost > 0) {
                        long sum = 0;
                        for (int prevMax = 0; prevMax < j; prevMax++) {
                            sum += dp[i - 1][cost - 1][prevMax];
                        }
                        dp[i][cost][j] = (dp[i][cost][j] + sum) % mod;
                    }
                }
            }
        }
        for (int max = 0; max < m; max++) {
            ans = (ans + dp[n - 1][k - 1][max]) % mod;
        }
        return (int) ans;
    }
}
