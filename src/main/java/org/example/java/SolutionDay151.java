package org.example.java;

//    medium #counting sort
//    Time complexity is O(n), where n is length of array nums
//    Space complexity is O(3)
//    https://leetcode.com/problems/sort-colors
//    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
//    color are adjacent, with the colors in the order red, white, and blue.
//    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//    You must solve this problem without using the library's sort function.
//    Example 1:
//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//    Example 2:
//    Input: nums = [2,0,1]
//    Output: [0,1,2]
public class SolutionDay151 {
    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int num : nums) freq[num]++;

        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i]-- > 0) nums[index++] = i;
        }
    }
}
