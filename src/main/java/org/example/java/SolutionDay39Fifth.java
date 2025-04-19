package org.example.java;

import java.util.Stack;

//    medium. #stack + 1D array + initial array to track j i k respectively
//    Time complexity O(n) instead of O(n^3) brute force or O(n^2) enhanced brute force
//    https://leetcode.com/problems/132-pattern
//    Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k]
//    such that i < j < k and nums[i] < nums[k] < nums[j].
//    Return true if there is a 132 pattern in nums, otherwise, return false.
//    Example 1:
//    Input: nums = [1,2,3,4]
//    Output: false
//    Explanation: There is no 132 pattern in the sequence.
//    Example 2:
//    Input: nums = [3,1,4,2]
//    Output: true
//    Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
//    Example 3:
//    Input: nums = [-1,3,2,0]
//    Output: true
//    Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
public class SolutionDay39Fifth {
    public static boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] mins = new int[n];
        mins[0] = nums[0];
        for (int i = 1; i < n; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = n - 1; j >= 1; j--) {
            if (nums[j] > mins[j]) {
                while (!stack.isEmpty() && stack.peek() <= mins[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
