package org.example;

//    easy #for loop and if-else statement
//    https://leetcode.com/problems/monotonic-array
//    An array is monotonic if it is either monotone increasing or monotone decreasing.
//    An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing
//    if for all i <= j, nums[i] >= nums[j].
//    Given an integer array nums, return true if the given array is monotonic, or false otherwise.
//    Example 1:
//    Input: nums = [1,2,2,3]
//    Output: true
//    Example 2:
//    Input: nums = [6,5,4,4]
//    Output: true
//    Example 3:
//    Input: nums = [1,3,2]
//    Output: false
public class SolutionDay39Sixth {
    public static boolean isMonotonic(int[] nums) {
        int direction = 0;
        if (nums.length <= 2) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                if (direction == -1) {
                    return false;
                }
                direction = 1;
            }
            if (nums[i] - nums[i - 1] < 0) {
                if (direction == 1) {
                    return false;
                }
                direction = -1;
            }
        }
        return true;
    }
}