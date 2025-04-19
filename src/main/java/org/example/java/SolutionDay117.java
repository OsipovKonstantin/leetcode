package org.example.java;

//    easy #matrix
//    Time complexity is O(row*col)
//    Space complexity is O(1)
//    https://leetcode.com/problems/island-perimeter
//    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0
//    represents water.
//    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
//    and there is exactly one island (i.e., one or more connected land cells).
//    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One
//    cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the
//    perimeter of the island.
//    Example 1:
//    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
//    Output: 16
//    Explanation: The perimeter is the 16 yellow stripes in the image above.
//    Example 2:
//    Input: grid = [[1]]
//    Output: 4
//    Example 3:
//    Input: grid = [[1,0]]
//    Output: 4
public class SolutionDay117 {
    public static int islandPerimeter(int[][] grid) {
        int[] rowDirs = new int[]{-1, 0, 1, 0};
        int[] colDirs = new int[]{0, 1, 0, -1};
        int rows = grid.length;
        int cols = grid[0].length;

        int ans = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int nextRow = row + rowDirs[i];
                        int nextCol = col + colDirs[i];
                        if (nextRow < 0 || nextRow >= rows || nextCol < 0
                                || nextCol >= cols || grid[nextRow][nextCol] == 0) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
