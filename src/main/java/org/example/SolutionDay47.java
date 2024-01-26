package org.example;

//    medium #dynamic programming (tabulation approach).
//     First optimization that reduce time complexity twice: when we meet cell with value 0 we continue loop
//    https://leetcode.com/problems/out-of-boundary-paths
//    There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed
//    to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid
//    boundary). You can apply at most maxMove moves to the ball.
//    Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of
//    the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
//    Example 1:
//    Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//    Output: 6
//    Example 2:
//    Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//    Output: 12
public class SolutionDay47 {
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][] prev = new int[m][n];
        int[][] curr = new int[m][n];
        prev[startRow][startColumn] = 1;
        long ans = 0;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (prev[j][k] == 0) continue;
                    if (k - 1 < 0) ans = (ans + prev[j][k]) % mod;
                    else curr[j][k - 1] = (curr[j][k - 1] + prev[j][k]) % mod;
                    if (k + 1 >= n) ans = (ans + prev[j][k]) % mod;
                    else curr[j][k + 1] = (curr[j][k + 1] + prev[j][k]) % mod;
                    if (j - 1 < 0) ans = (ans + prev[j][k]) % mod;
                    else curr[j - 1][k] = (curr[j - 1][k] + prev[j][k]) % mod;
                    if (j + 1 >= m) ans = (ans + prev[j][k]) % mod;
                    else curr[j + 1][k] = (curr[j + 1][k] + prev[j][k]) % mod;
                }
            }
            prev = curr;
            curr = new int[m][n];
        }
        return (int) ans;
    }
}
