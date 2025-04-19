package org.example.java;

//    easy #moore voting algorithm. Time complexity is O(n), space complexity is O(1)
//    https://leetcode.com/problems/majority-element
//    Given an array nums of size n, return the majority element.
//    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority
//    element always exists in the array.
//    Example 1:
//    Input: nums = [3,2,3]
//    Output: 3
//    Example 2:
//    Input: nums = [2,2,1,1,1,2,2]
//    Output: 2
public class SolutionDay64Second {
    public static int majorityElement(int[] nums) {
        int counter = 0;
        int candidate = -1;
        for (int num : nums) {
            if (candidate != num) {
                if (counter != 0) counter--;
                else {
                    candidate = num;
                    counter = 1;
                }
            } else counter++;
        }
        return candidate;
    }
}
