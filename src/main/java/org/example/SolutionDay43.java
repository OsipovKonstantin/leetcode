package org.example;

//    medium #tortoise and hare algorithm (floyd's cycle detection algorithm). Space complexity O(1)
//    (as required in task)
//    https://leetcode.com/problems/find-the-duplicate-number
//    Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//    There is only one repeated number in nums, return this repeated number.
//    You must solve the problem without modifying the array nums and uses only constant extra space.
//    Example 1:
//    Input: nums = [1,3,4,2,2]
//    Output: 2
//    Example 2:
//    Input: nums = [3,1,3,4,2]
//    Output: 3
public class SolutionDay43 {
    public static int findDuplicate(int[] nums) {
        int tortoise = 0;
        int hare = 0;
        while (true) {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            if (tortoise == hare) {
                break;
            }
        }
        int tortoise2 = 0;
        while (true) {
            tortoise = nums[tortoise];
            tortoise2 = nums[tortoise2];
            if (tortoise == tortoise2) {
                return tortoise;
            }
        }
    }
}
