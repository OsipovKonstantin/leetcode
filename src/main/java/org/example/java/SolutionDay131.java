package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #backtracking
//    Time complexity is O(2^n)
//    Space complexity is O(h), where h is height of stack
//    https://leetcode.com/problems/subsets
//    Given an integer array nums of unique elements, return all possible
//    subsets
//     (the power set).
//    The solution set must not contain duplicate subsets. Return the solution in any order.
//    Example 1:
//    Input: nums = [1,2,3]
//    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//    Example 2:
//    Input: nums = [0]
//    Output: [[],[0]]
public class SolutionDay131 {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, temp, 0);
        return ans;
    }

    private static void backtrack(int[] nums, List<Integer> temp, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        backtrack(nums, temp, index + 1);
        temp.add(nums[index]);
        backtrack(nums, temp, index + 1);
        temp.remove(temp.size() - 1);
    }
}
