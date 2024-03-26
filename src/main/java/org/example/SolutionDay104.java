package org.example;

//    hard #array (tricky approach, but not hard)
//    Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/first-missing-positive
//    Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//    You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//    Example 1:
//    Input: nums = [1,2,0]
//    Output: 3
//    Explanation: The numbers in the range [1,2] are all in the array.
//    Example 2:
//    Input: nums = [3,4,-1,1]
//    Output: 2
//    Explanation: 1 is in the array but 2 is missing.
//    Example 3:
//    Input: nums = [7,8,9,11,12]
//    Output: 1
//    Explanation: The smallest positive integer 1 is missing.
public class SolutionDay104 {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int absNum = Math.abs(nums[i]);
            if (absNum > 0 && absNum - 1 < n) {
                if (nums[absNum - 1] == 0) nums[absNum - 1] = -1000000;
                else nums[absNum - 1] = Math.abs(nums[absNum - 1]) * -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return n + 1;
    }
}
