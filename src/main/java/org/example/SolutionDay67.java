package org.example;

import java.util.Arrays;

//    medium #dynamic programming. Tabulation approach. Time complexity is O(n^2), space complexity is O(n)
//    https://leetcode.com/problems/number-of-longest-increasing-subsequence
//    Given an integer array nums, return the number of longest increasing subsequences.
//    Notice that the sequence has to be strictly increasing.
//    Example 1:
//    Input: nums = [1,3,5,4,7]
//    Output: 2
//    Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
//    Example 2:
//    Input: nums = [2,2,2,2,2]
//    Output: 5
//    Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences
//    of length 1, so output 5.
public class SolutionDay67 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] counter = new int[n];

        Arrays.fill(length, 1);
        Arrays.fill(counter, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 > length[i]) {
                        counter[i] = counter[j];
                        length[i] = length[j] + 1;
                        maxLen = Math.max(maxLen, length[i]);
                    } else if (length[i] == length[j] + 1)
                        counter[i] += counter[j];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (length[i] == maxLen) ans += counter[i];
        return ans;
    }
}
