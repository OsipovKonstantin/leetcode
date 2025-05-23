package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    hard. Dynamic programming with 2D memoization and counting during fulling of memoization array
//    https://leetcode.com/problems/arithmetic-slices-ii-subsequence
//    Given an integer array nums, return the number of all the arithmetic subsequences of nums.
//    A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference
//    between any two consecutive elements is the same.
//    For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
//    For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
//    A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
//    For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
//    The test cases are generated so that the answer fits in 32-bit integer.
//    Example 1:
//    Input: nums = [2,4,6,8,10]
//    Output: 7
//    Explanation: All arithmetic subsequence slices are:
//    [2,4,6]
//    [4,6,8]
//    [6,8,10]
//    [2,4,6,8]
//    [4,6,8,10]
//    [2,4,6,8,10]
//    [2,6,10]
//    Example 2:
//    Input: nums = [7,7,7,7,7]
//    Output: 16
//    Explanation: Any subsequence of this array is arithmetic.
public class SolutionDay28Second {
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                int diffInt = (int) diff;
                dp[i].put(diffInt, dp[i].getOrDefault(diffInt, 0) + 1);
                if (dp[j].containsKey(diffInt)) {
                    ans += dp[j].get(diffInt);
                    dp[i].put(diffInt, dp[j].get(diffInt) + dp[i].get(diffInt));
                }
            }
        }
        return ans;
    }
}
