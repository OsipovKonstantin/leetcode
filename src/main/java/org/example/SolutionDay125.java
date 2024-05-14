package org.example;

//    medium #backtracking
//    Time complexity is O(n*m*4^g), where n is number of rows, m is number of cols, g is maximum number of gold cells
//    that miner can pick
//    Space complexity is g because of stack in backtracking
//    https://leetcode.com/problems/path-with-maximum-gold
//    In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that
//    cell, 0 if it is empty.
//    Return the maximum amount of gold you can collect under the conditions:
//    Every time you are located in a cell you will collect all the gold in that cell.
//    From your position, you can walk one step to the left, right, up, or down.
//    You can't visit the same cell more than once.
//    Never visit a cell with 0 gold.
//    You can start and stop collecting gold from any position in the grid that has some gold.
//    Example 1:
//    Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
//    Output: 24
//    Explanation:
//    [[0,6,0],
//     [5,8,7],
//     [0,9,0]]
//    Path to get the maximum gold, 9 -> 8 -> 7.
//    Example 2:
//    Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//    Output: 28
//    Explanation:
//    [[1,0,7],
//     [2,0,6],
//     [3,4,5],
//     [0,3,0],
//     [9,0,20]]
//    Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
public class SolutionDay125 {
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int getMaximumGold(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] != 0) {
                    ans = Math.max(ans, backtrack(grid, row, col));
                }
            }
        }
        return ans;
    }

    private static int backtrack(int[][] grid, int row, int col) {
        int max = 0;
        int temp = grid[row][col];
        grid[row][col] = 0;
        for (int[] dir : dirs) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length
                    && grid[nextRow][nextCol] != 0) {
                max = Math.max(max, backtrack(grid, nextRow, nextCol));
            }
        }
        grid[row][col] = temp;
        return temp + max;
    }
}
