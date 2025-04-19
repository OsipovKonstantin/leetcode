package org.example.java;

//    medium. #binary search (first binary search that implemented without mistakes)
//    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a
//    given target value.
//    If target is not found in the array, return [-1, -1].
//    You must write an algorithm with O(log n) runtime complexity.
//    Example 1:
//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//    Example 2:
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]
//    Example 3:
//    Input: nums = [], target = 0
//    Output: [-1,-1]
public class SolutionDay37Fifth {
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[]{-1, -1};
        if (n == 0) {
            return ans;
        }
        int leftIndex = findLeft(nums, target);
        if (nums[leftIndex] != target) {
            return ans;
        }
        int rightIndex = findRight(nums, target);
        if (nums[rightIndex] != target) {
            return ans;
        }
        return new int[]{leftIndex, rightIndex};
    }

    private static int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
