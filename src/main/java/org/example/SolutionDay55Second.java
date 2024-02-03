package org.example;

import java.util.Arrays;

//    medium #dynamic programming. This solution implements a top-down approach with memoization. The int[] dp helps us
//    reuse result of repeated recursive computations. Here, dp[i] stores the result of recursion on the ith index
//    Time complexity is O(n*k), where n is size of array arr and k is maximum length of subarray
//    Space complexity is O(n), because we store 1D array dp
//    https://leetcode.com/problems/partition-array-for-maximum-sum
//    Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
//    After partitioning, each subarray has their values changed to become the maximum value of that subarray.
//    Return the largest sum of the given array after partitioning. Test cases are generated so that the answer
//    fits in a 32-bit integer.
//    Example 1:
//    Input: arr = [1,15,7,9,2,5,10], k = 3
//    Output: 84
//    Explanation: arr becomes [15,15,15,9,10,10,10]
//    Example 2:
//    Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
//    Output: 83
//    Example 3:
//    Input: arr = [1], k = 1
//    Output: 1
public class SolutionDay55Second {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return maxSum(dp, arr, k, 0);
    }

    private static int maxSum(int[] dp, int[] arr, int k, int start) {
        int n = arr.length;
        if (start >= n) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int ans = 0;
        int maxVal = 0;
        int end = Math.min(k, n - start);
        for (int i = 0; i < end; i++) {
            maxVal = Math.max(maxVal, arr[start + i]);
            ans = Math.max(ans, maxVal * (i + 1) + maxSum(dp, arr, k, start + i + 1));
        }
        return dp[start] = ans;
    }
}
