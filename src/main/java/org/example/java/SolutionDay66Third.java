package org.example.java;

//    medium #dynamic programming. Tabulation approach with space optimization
//    Time complexity is O(k*n^2), space complexity is O(n^2)
//    https://leetcode.com/problems/knight-probability-in-chessboard
//    On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows
//    and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
//    A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal
//    direction, then one cell in an orthogonal direction.
//    Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece
//    would go off the chessboard) and moves there.
//    The knight continues moving until it has made exactly k moves or has moved off the chessboard.
//    Return the probability that the knight remains on the board after it has stopped moving.
//    Example 1:
//    Input: n = 3, k = 2, row = 0, column = 0
//    Output: 0.06250
//    Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
//    From each of those positions, there are also two moves that will keep the knight on the board.
//    The total probability the knight stays on the board is 0.0625.
//    Example 2:
//    Input: n = 1, k = 0, row = 0, column = 0
//    Output: 1.00000
public class SolutionDay66Third {
    public static double knightProbability(int n, int k, int row, int column) {
        int[] dx = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        double[][] cur = new double[n][n];
        cur[row][column] = 1;
        double[][] next = new double[n][n];
        for (int i = 0; i < k; i++) {
            for (int rw = 0; rw < n; rw++) {
                for (int cn = 0; cn < n; cn++) {
                    if (cur[rw][cn] != 0) {
                        for (int u = 0; u < dx.length; u++) {
                            int nextX = cn + dx[u];
                            int nextY = rw + dy[u];
                            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n)
                                next[nextY][nextX] += cur[rw][cn] / 8;
                        }
                    }
                }
            }
            cur = next;
            next = new double[n][n];
        }

        double ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans += cur[i][j];
            }
        }
        return ans;
    }
}
