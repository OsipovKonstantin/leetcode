package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    medium #dynamic programming #hashmap
//    Time complexity is O(n^2), because we use 2 loops to traverse an array of size n
//    Space complexity is O(n^2), because of the size of the dp array
//    https://leetcode.com/problems/length-of-longest-fibonacci-subsequence
public class SolutionDay176Third {
    public static int lenLongestFibSubseq(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
        }
        int[][] dp = new int[len][len];
        int ans = 0;
        for (int row = len - 1; row >= 0; row--) {
            for (int col = row - 1; col >= 0; col--) {
                int prev = arr[col];
                int cur = arr[row];
                int next = prev + cur;
                if (!map.containsKey(next)) {
                    dp[row][col] = 2;
                } else {
                    dp[row][col] = 1 + dp[map.get(next)][row];
                    ans = Math.max(ans, dp[row][col]);
                }
            }
        }
        return ans;
    }
}
