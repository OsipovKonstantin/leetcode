package org.example.java;

import java.util.Arrays;

//    medium #dynamic programming (tabulation). Optimized by sorting nums and break loop with them in method traverseNums
//    Second optimization - using two 1D arrays (prev and curr) instead of one 2D (int[][] dp)
//    Third optimization - i variable in loop has step as a min number in nums[] (and variable j is tied to variable i).
//    It allows us to reduce time complexity many times. Before optimization 78 ms, after - 4 ms (20 times faster)
//    https://leetcode.com/problems/combination-sum-iv
//    Given an array of distinct integers nums and a target integer target, return the number of possible combinations
//    that add up to target.
//    The test cases are generated so that the answer can fit in a 32-bit integer.
//    Example 1:
//    Input: nums = [1,2,3], target = 4
//    Output: 7
//    Explanation:
//    The possible combination ways are:
//    (1, 1, 1, 1)
//    (1, 1, 2)
//    (1, 2, 1)
//    (1, 3)
//    (2, 1, 1)
//    (2, 2)
//    (3, 1)
//    Note that different sequences are counted as different combinations.
//    Example 2:
//    Input: nums = [9], target = 3
//    Output: 0
public class SolutionDay46Sixth {
    public static int combinationSum4(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (nums.length == 1) {
            if (nums[0] > target) {
                return 0;
            } else if (nums[0] == target) {
                return 1;
            }
        }
        int[] prev = new int[target + 1];
        int[] curr = new int[target + 1];

        for (int num : nums) {
            if (num <= target) {
                prev[num - 1]++;
            }
        }
        Arrays.sort(nums);
        int ans = prev[target - 1];
        for (int i = nums[0]; i < target; i += nums[0]) {
            for (int j = i; j < target; j++) {
                curr[j] = traverseNums(nums, prev, i, j);
            }
            prev = curr;
            curr = new int[target + 1];
            ans += prev[target - 1];
        }
        return ans;
    }

    private static int traverseNums(int[] nums, int[] prev, int i, int j) {
        int count = 0;
        int minNum = nums[0];
        for (int num : nums) {
            if (j - num < i - minNum) {
                break;
            }
            count += prev[j - num];
        }
        return count;
    }
}