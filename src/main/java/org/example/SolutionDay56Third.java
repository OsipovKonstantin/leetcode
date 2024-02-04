package org.example;

import java.util.Arrays;

//    medium #two passes (from top-left to bottom-right, then from bottom-right to top-left) #dynamic programming
//    Time complexity is O(rows*cols)
//    Space complexity is O(1), if we don't take into account answer (int[][] dp)
//    https://leetcode.com/problems/01-matrix
//    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
//    The distance between two adjacent cells is 1.
//    Example 1:
//    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//    Output: [[0,0,0],[0,1,0],[0,0,0]]
//    Example 2:
//    Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//    Output: [[0,0,0],[0,1,0],[1,2,1]]
public class SolutionDay56Third {
    public static int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] dp = new int[rows][cols];
        for (int[] dpRow : dp)
            Arrays.fill(dpRow, Integer.MAX_VALUE);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (mat[row][col] == 0)
                    dp[row][col] = 0;
                if (row - 1 >= 0 && dp[row - 1][col] != Integer.MAX_VALUE)
                    dp[row][col] = Math.min(dp[row][col], dp[row - 1][col] + 1);
                if (col - 1 >= 0 && dp[row][col - 1] != Integer.MAX_VALUE)
                    dp[row][col] = Math.min(dp[row][col], dp[row][col - 1] + 1);
            }
        }
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                if (mat[row][col] == 0)
                    dp[row][col] = 0;
                if (row + 1 < rows && dp[row + 1][col] != Integer.MAX_VALUE)
                    dp[row][col] = Math.min(dp[row][col], dp[row + 1][col] + 1);
                if (col + 1 < cols && dp[row][col + 1] != Integer.MAX_VALUE)
                    dp[row][col] = Math.min(dp[row][col], dp[row][col + 1] + 1);
            }
        }
        return dp;
    }
}
