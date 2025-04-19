package org.example.java;

//    easy #two pointers
//    Time complexity is O(n), space comlexity is O(n)
//    https://leetcode.com/problems/squares-of-a-sorted-array
//    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//    Example 1:
//    Input: nums = [-4,-1,0,3,10]
//    Output: [0,1,9,16,100]
//    Explanation: After squaring, the array becomes [16,1,0,9,100].
//    After sorting, it becomes [0,1,9,16,100].
//    Example 2:
//    Input: nums = [-7,-3,2,3,11]
//    Output: [4,9,9,49,121]
public class SolutionDay82 {
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare > rightSquare) {
                ans[i] = leftSquare;
                left++;
            } else {
                ans[i] = rightSquare;
                right--;
            }
        }
        return ans;
    }
}
