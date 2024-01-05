package org.example;

//medium. Dynamic programming with 1D array
//https://leetcode.com/problems/longest-increasing-subsequence
//Given an integer array nums, return the length of the longest strictly increasing subsequence.
//Example 1:
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
//Example 2:
//Input: nums = [0,1,0,3,2,3]
//Output: 4
//Example 3:
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
public class SolutionDay26Second {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int counter = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    counter = Math.max(counter, dp[j] + 1);
                }
            }
            dp[i] = counter;
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }
}
