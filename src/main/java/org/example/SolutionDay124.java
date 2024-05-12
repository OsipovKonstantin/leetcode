package org.example;

import java.util.PriorityQueue;

//    easy #priority queue #sliding window (but actually brute force is faster because max value in 3*3 matrix
//    around each cell. If it was 5*5 or more priority queue with sliding window would be more efficient)
//    Time complexity is O(n*n*logn)
//    Space complexity is O(n^2)
//    You are given an n x n integer matrix grid.
//    Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
//    maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column
//    j + 1.
//    In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
//    Return the generated matrix.
//    Example 1:
//    Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
//    Output: [[9,9],[8,6]]
//    Explanation: The diagram above shows the original matrix and the generated matrix.
//    Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix
//    in grid.
//    Example 2:
//    Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
//    Output: [[2,2,2],[2,2,2],[2,2,2]]
//    Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
public class SolutionDay124 {
    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] temp = new int[n][n - 2];
        //col(first loop) or row (second loop), value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int row = 0; row < n; row++) {
            pq.offer(new int[]{0, grid[row][0]});
            pq.offer(new int[]{1, grid[row][1]});
            for (int col = 2; col < n; col++) {
                pq.offer(new int[]{col, grid[row][col]});
                temp[row][col - 2] = pq.peek()[1];
                while (pq.peek()[0] <= col - 2) pq.poll();
            }
            pq.clear();
        }
        int[][] ans = new int[n - 2][n - 2];
        for (int col = 0; col < n - 2; col++) {
            pq.offer(new int[]{0, temp[0][col]});
            pq.offer(new int[]{1, temp[1][col]});
            for (int row = 2; row < n; row++) {
                pq.offer(new int[]{row, temp[row][col]});
                ans[row - 2][col] = pq.peek()[1];
                while (pq.peek()[0] <= row - 2) pq.poll();
            }
            pq.clear();
        }
        return ans;
    }
}
