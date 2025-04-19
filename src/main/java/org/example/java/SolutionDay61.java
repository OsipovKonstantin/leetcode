package org.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//    medium #dynamic programming. Tabulation approach. Time complexity is O(n^2). Not n^3, because during list.add we
//    can actually add at most 32 elements (each element has no remainder so each next number in list is bigger than
//    previous number at least 2 times). For example [1,2,4,8,16,32,64 and so on, max 32 element if we use integer values]
//    https://leetcode.com/problems/largest-divisible-subset
//    Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i],
//    answer[j]) of elements in this subset satisfies:
//    answer[i] % answer[j] == 0, or
//    answer[j] % answer[i] == 0
//    If there are multiple solutions, return any of them.
//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [1,2]
//    Explanation: [1,3] is also accepted.
//    Example 2:
//    Input: nums = [1,2,4,8]
//    Output: [1,2,4,8]
public class SolutionDay61 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        List<Integer>[] dp = new ArrayList[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
            List<Integer> temp = new ArrayList<>();
            for (int j = i + 1; j < n; j++)
                if (nums[j] % nums[i] == 0) temp = temp.size() < dp[j].size() ? dp[j] : temp;
            dp[i].addAll(temp);
            res = res.size() < dp[i].size() ? dp[i] : res;
        }
        return res;
    }
}
