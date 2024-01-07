package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    medium. Iterative approach with counting frequencies in hashmap. Idea is similar to Deep-First-Search
//    https://leetcode.com/problems/restore-the-array-from-adjacent-pairs
//    There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do
//    remember every pair of adjacent elements in nums.
//    You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates
//    that the elements ui and vi are adjacent in nums.
//    It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either
//    as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
//    Return the original array nums. If there are multiple solutions, return any of them.
//    Example 1:
//    Input: adjacentPairs = [[2,1],[3,4],[3,2]]
//    Output: [1,2,3,4]
//    Explanation: This array has all its adjacent pairs in adjacentPairs.
//    Notice that adjacentPairs[i] may not be in left-to-right order.
//    Example 2:
//    Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
//    Output: [-2,4,1,-3]
//    Explanation: There can be negative numbers.
//    Another solution is [-3,1,4,-2], which would also be accepted.
//    Example 3:
//    Input: adjacentPairs = [[100000,-100000]]
//    Output: [100000,-100000]
public class SolutionDay28 {
    public static int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;
        if (n == 2) {
            return adjacentPairs[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            List<Integer> list = map.getOrDefault(pair[0], new ArrayList<>());
            list.add(pair[1]);
            List<Integer> secondList = map.getOrDefault(pair[1], new ArrayList<>());
            secondList.add(pair[0]);
            map.put(pair[0], list);
            map.put(pair[1], secondList);
        }
        int[] ans = new int[n];
        ans[0] = findFirstOrLast(map);
        ans[1] = map.get(ans[0]).get(0);
        for (int i = 2; i < n; i++) {
            for (int next : map.get(ans[i - 1])) {
                if (next == ans[i - 2]) {
                    continue;
                }
                ans[i] = next;
            }
        }
        return ans;
    }

    public static int findFirstOrLast(Map<Integer, List<Integer>> map) {
        int firstOrLast = -1;
        for (Map.Entry<Integer, List<Integer>> es : map.entrySet()) {
            if (es.getValue().size() == 1) {
                return es.getKey();
            }
        }
        return firstOrLast;
    }
}
