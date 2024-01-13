package org.example;

import java.util.PriorityQueue;

//    hard. #PriorityQueue (O(n*logn) time complexity) instead of dynamic programming with 1D array memoization O(n*k)
//     time complexity
//    https://leetcode.com/problems/constrained-subsequence-sum
//    Given an integer array nums and an integer k, return the maximum sum of a non-empty subsequence of that array
//    such that for every two consecutive integers in the subsequence, nums[i] and nums[j], where i < j, the condition
//    j - i <= k is satisfied.
//    A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array, leaving
//    the remaining elements in their original order.
//    Example 1:
//    Input: nums = [10,2,-10,5,20], k = 2
//    Output: 37
//    Explanation: The subsequence is [10, 2, 5, 20].
//    Example 2:
//    Input: nums = [-1,-2,-3], k = 1
//    Output: -1
//    Explanation: The subsequence must be non-empty, so we choose the largest number.
//    Example 3:
//    Input: nums = [10,-2,-10,-5,20], k = 2
//    Output: 23
//    Explanation: The subsequence is [10, -2, -5, 20].
public class SolutionDay34Third {
    public static int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr2[0] - arr1[0]);
        //first value - number, second - index of element in nums
        pq.offer(new int[]{nums[0], 0});
        int n = nums.length;
        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            while (i - pq.peek()[1] > k) {
                pq.remove();
            }
            int curr = nums[i] + Math.max(0, pq.peek()[0]);
            ans = Math.max(ans, curr);
            pq.offer(new int[]{curr, i});
        }
        return ans;
    }
}