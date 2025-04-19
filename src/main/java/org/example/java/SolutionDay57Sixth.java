package org.example.java;

//    medium (really easy) #dynamic programming
//    https://leetcode.com/problems/unique-paths-ii
//    You are given an m x n integer array grid. There is a robot initially located at the top-left corner
//    (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can
//    only move either down or right at any point in time.
//    An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any
//    square that is an obstacle.
//    Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//    The testcases are generated so that the answer will be less than or equal to 2 * 109.
//    Example 1:
//    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//    Output: 2
//    Explanation: There is one obstacle in the middle of the 3x3 grid above.
//    There are two ways to reach the bottom-right corner:
//    1. Right -> Right -> Down -> Down
//    2. Down -> Down -> Right -> Right
//    Example 2:
//    Input: obstacleGrid = [[0,1],[0,0]]
//    Output: 1
public class SolutionDay57Sixth {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rows - 1][cols - 1] == 1) return 0;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (obstacleGrid[row][col] == 1) continue;
                if (row - 1 >= 0) dp[row][col] += dp[row - 1][col];
                if (col - 1 >= 0) dp[row][col] += dp[row][col - 1];
            }
        }
        return dp[rows - 1][cols - 1];
    }
}