package org.example.java;

import java.util.Arrays;

//    hard #dynamic programming. Recursive approach with memoization. Poorly written solution, but I did it myself
//    Time complexity is between O(2^n) and O(n*sum), because memoization is not optimized,
//    where n is number of rods and sum is sum of rod's length
//    Space complexity is O(n*sum)
//    https://leetcode.com/problems/tallest-billboard
//    You are installing a billboard and want it to have the largest height. The billboard will have two steel supports,
//    one on each side. Each steel support must be an equal height.
//    You are given a collection of rods that can be welded together. For example, if you have rods of lengths 1, 2,
//    and 3, you can weld them together to make a support of length 6.
//    Return the largest possible height of your billboard installation. If you cannot support the billboard, return 0.
//    Example 1:
//    Input: rods = [1,2,3,6]
//    Output: 6
//    Explanation: We have two disjoint subsets {1,2,3} and {6}, which have the same sum = 6.
//    Example 2:
//    Input: rods = [1,2,3,4,5,6]
//    Output: 10
//    Explanation: We have two disjoint subsets {2,3,5} and {4,6}, which have the same sum = 10.
//    Example 3:
//    Input: rods = [1,2]
//    Output: 0
//    Explanation: The billboard cannot be supported, so we return 0.
public class SolutionDay80Second {
    private static int[][] memo;

    public static int tallestBillboard(int[] rods) {
        int maxDiff = 0;
        for (int rod : rods) maxDiff += rod;
        memo = new int[rods.length][maxDiff + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        traverse(rods, 0, 0, 0);
        return memo[rods.length - 1][0] == -1 ? 0 : memo[rods.length - 1][0];
    }

    private static void traverse(int[] rods, int index, int first, int second) {
        if (index == rods.length) return;
        if (first == second) memo[index][0] = Math.max(memo[index][0], first);
        int nextFirst = first + rods[index];
        if (memo[index][Math.abs(nextFirst - second)] < Math.max(nextFirst, second)) {
            memo[index][Math.abs(nextFirst - second)] = Math.max(nextFirst, second);
            traverse(rods, index + 1, nextFirst, second);
        }

        int nextSecond = second + rods[index];
        if (memo[index][Math.abs(first - nextSecond)] < Math.max(first, nextSecond)) {
            memo[index][Math.abs(first - nextSecond)] = Math.max(first, nextSecond);
            traverse(rods, index + 1, first, nextSecond);
        }
        traverse(rods, index + 1, first, second);
        return;
    }
}
