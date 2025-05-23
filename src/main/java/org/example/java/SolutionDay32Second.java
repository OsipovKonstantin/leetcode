package org.example.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//    medium. #binary tree #dynamic programming #Math logic
//    https://leetcode.com/problems/binary-trees-with-factors
//    Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
//    We make a binary tree using these integers, and each number may be used for any number of times. Each non-leaf
//    node's value should be equal to the product of the values of its children.
//    Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
//    Example 1:
//    Input: arr = [2,4]
//    Output: 3
//    Explanation: We can make these trees: [2], [4], [4, 2, 2]
//    Example 2:
//    Input: arr = [2,4,5,10]
//    Output: 7
//    Explanation: We can make these trees: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2].
public class SolutionDay32Second {
    public static int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
            dp[i] = 1L;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    dp[i] = dp[i] + dp[j] * dp[map.get(arr[i] / arr[j])];
                }
            }
        }
        long ans = 0;
        for (long value : dp) {
            ans = (ans + value) % mod;
        }
        return (int) ans;
    }
}
