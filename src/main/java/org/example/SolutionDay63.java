package org.example;

//    hard #dynamic programming. Recursive approach with memoization
//    Time complexity is O(rows*cols^2), where rows are number of rows in grid, cols are number of columns in grid
//    Space complexity is O(rows*cols^2)
//    https://leetcode.com/problems/cherry-pickup-ii
//    You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number
//    of cherries that you can collect from the (i, j) cell.
//    You have two robots that can collect cherries for you:
//    Robot #1 is located at the top-left corner (0, 0), and
//    Robot #2 is located at the top-right corner (0, cols - 1).
//    Return the maximum number of cherries collection using both robots by following the rules below:
//    From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
//    When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
//    When both robots stay in the same cell, only one takes the cherries.
//    Both robots cannot move outside of the grid at any moment.
//    Both robots should reach the bottom row in grid.
//    Example 1:
//    Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
//    Output: 24
//    Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
//    Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
//    Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
//    Total of cherries: 12 + 12 = 24.
//    Example 2:
//    Input: grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
//    Output: 28
//    Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
//    Cherries taken by Robot #1, (1 + 9 + 5 + 2) = 17.
//    Cherries taken by Robot #2, (1 + 3 + 4 + 3) = 11.
//    Total of cherries: 17 + 11 = 28.
public class SolutionDay63 {
    public static int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] memo = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < cols; k++)
                    memo[i][j][k] = -1;
        return traverse(grid, memo, 0, 0, cols - 1);
    }

    private static int traverse(int[][] grid, int[][][] memo, int row, int first, int second) {
        if (row >= grid.length) return 0;
        if (memo[row][first][second] != -1) {
            return memo[row][first][second];
        }
        int cols = grid[0].length;
        int ans = 0;
        int cur = 0;
        if (first == second) cur = grid[row][first];
        else cur = grid[row][first] + grid[row][second];
        for (int i = first - 1; i <= first + 1; i++) {
            for (int j = second - 1; j <= second + 1; j++) {
                if (i < 0 || i > cols - 1 || j < 0 || j > cols - 1) continue;
                ans = Math.max(ans, cur + traverse(grid, memo, row + 1, i, j));
            }
        }
        memo[row][first][second] = ans;
        memo[row][second][first] = ans;
        return memo[row][first][second];
    }
}
