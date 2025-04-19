package org.example.java;

//    medium #dynamic programming (tabulation approach)
//    https://leetcode.com/problems/unique-paths
//    There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
//    The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
//    down or right at any point in time.
//    Given the two integers m and n, return the number of possible unique paths that the robot can take to reach
//    the bottom-right corner.
//    The test cases are generated so that the answer will be less than or equal to 2 * 109.
//    Example 1:
//    Input: m = 3, n = 7
//    Output: 28
//    Example 2:
//    Input: m = 3, n = 2
//    Output: 3
//    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//    1. Right -> Down -> Down
//    2. Down -> Down -> Right
//    3. Down -> Right -> Down
public class SolutionDay49Second {
    public static int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        int[] next = new int[n];
        cur[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    cur[j + 1] += cur[j];
                }
                if (i + 1 < m) {
                    next[j] += cur[j];
                }
            }
            if (i != m - 1) {
                cur = next;
            }
            next = new int[n];
        }
        return cur[n - 1];
    }
}
