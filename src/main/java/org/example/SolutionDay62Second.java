package org.example;

import java.util.ArrayList;
import java.util.List;

//medium #backtracking. The crux of backtracking is adding something temporarily and then removing it afterward
//we use boolean[] seen to check visited element with O(1) time instead of utilizing temp.contains() that require O(n) time
//Overall time complexity is O(n!)
//https://leetcode.com/problems/permutations
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//Example 1:
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//Input: nums = [1]
//Output: [[1]]
public class SolutionDay62Second {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, new ArrayList<>(), new boolean[nums.length]);
        return ans;
    }

    private static void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> temp, boolean[] seen) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (seen[i]) continue;
                temp.add(num);
                seen[i] = true;
                backtrack(ans, nums, temp, seen);
                temp.remove(temp.size() - 1);
                seen[i] = false;
            }
        }
    }
}
