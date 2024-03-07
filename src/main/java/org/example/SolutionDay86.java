package org.example;

import java.util.Arrays;

//    hard #recursion #dynamic programming with memoization
//    Time complexity is O(rows*cols), where rows is number of row in grid, cols in number of columns in grid
//    Space complexity is O(rows*cols)
//    https://leetcode.com/problems/number-of-increasing-paths-in-a-grid
//    You are given an m x n integer matrix grid, where you can move from a cell to any adjacent cell in all
//    4 directions.
//    Return the number of strictly increasing paths in the grid such that you can start from any cell and end
//    at any cell. Since the answer may be very large, return it modulo 109 + 7.
//    Two paths are considered different if they do not have exactly the same sequence of visited cells.
//    Example 1:
//    Input: grid = [[1,1],[3,4]]
//    Output: 8
//    Explanation: The strictly increasing paths are:
//    - Paths with length 1: [1], [1], [3], [4].
//    - Paths with length 2: [1 -> 3], [1 -> 4], [3 -> 4].
//    - Paths with length 3: [1 -> 3 -> 4].
//    The total number of paths is 4 + 3 + 1 = 8.
//    Example 2:
//    Input: grid = [[1],[2]]
//    Output: 3
//    Explanation: The strictly increasing paths are:
//    - Paths with length 1: [1], [2].
//    - Paths with length 2: [1 -> 2].
//    The total number of paths is 2 + 1 = 3.
public class SolutionDay86 {
    private static int[][] dp;
    private static final int mod = 1000000007;

    public static int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp = new int[rows][cols];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = 0;
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                ans = (ans + traverse(grid, row, col, 0)) % mod;
        return ans;
    }

    private static int traverse(int[][] grid, int row, int col, int prevVal) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || prevVal >= grid[row][col])
            return 0;
        if (dp[row][col] != -1)
            return dp[row][col];
        int curVal = grid[row][col];
        dp[row][col] = (1 + traverse(grid, row + 1, col, curVal) + traverse(grid, row, col + 1, curVal)
                + traverse(grid, row - 1, col, curVal) + traverse(grid, row, col - 1, curVal)) % mod;
        return dp[row][col];
    }
}
