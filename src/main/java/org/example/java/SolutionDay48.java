package org.example.java;

//    hard #dynamic programming #combinatorics #sliding window. This task is Triangle of Mahonian Numbers.
//    Time complexity O(n*k)
//    https://leetcode.com/problems/k-inverse-pairs-array
//    For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and
//    nums[i] > nums[j].
//    Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there
//    are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.
//    Example 1:
//    Input: n = 3, k = 0
//    Output: 1
//    Explanation: Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pairs.
//    Example 2:
//    Input: n = 3, k = 1
//    Output: 2
//    Explanation: The array [1,3,2] and [2,1,3] have exactly 1 inverse pair.
public class SolutionDay48 {
    public static int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (n == 1) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        long[] prev = new long[k + 1];
        long[] curr = new long[k + 1];
        prev[0] = 1;
        for (int i = 2; i <= n; i++) {
            long slidingWindow = 0;
            int maxK = i * (i - 1) / 2;
            for (int j = 0; j <= Math.min(k, maxK); j++) {
                if (j - i >= 0) slidingWindow = (slidingWindow - prev[j - i] + mod) % mod;
                slidingWindow = (slidingWindow + prev[j]) % mod;
                curr[j] = slidingWindow;
            }
            prev = curr;
            curr = new long[k + 1];
        }
        return (int) prev[k];
    }
}
