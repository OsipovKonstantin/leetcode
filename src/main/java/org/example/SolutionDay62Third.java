package org.example;

import java.util.ArrayList;
import java.util.List;

//    medium #backtracking. Algorithm is similar for permutation, but here we use pointer cur
//    instead of boolean[] seen to have no duplicates in output list. Time complexity is O(k*number of combinations) =
//    O(k*n!/(k!*(n-k)!)), where k is quantity of numbers in combination and n is maximum value of each number. First k
//    in time complexity is number of operations for copy each combination from temp list to ans list
//    https://leetcode.com/problems/combinations
//    Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//    You may return the answer in any order.
//    Example 1:
//    Input: n = 4, k = 2
//    Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//    Explanation: There are 4 choose 2 = 6 total combinations.
//    Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
//    Example 2:
//    Input: n = 1, k = 1
//    Output: [[1]]
//    Explanation: There is 1 choose 1 = 1 total combination.
public class SolutionDay62Third {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    private static void backtrack(int n, int k, List<List<Integer>> ans, List<Integer> temp, int cur) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = cur; i <= n; i++) {
                temp.add(i);
                backtrack(n, k, ans, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
