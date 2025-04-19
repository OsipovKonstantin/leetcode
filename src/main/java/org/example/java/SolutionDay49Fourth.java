package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    hard (really HARD!) #prefix sum. Solution of this task has 2 steps: constructing prefix sum for matrix and
//    calculating number of submatrix with prefixSum equal to target.
//    Second part inspired by 4th approach on https://leetcode.com/problems/subarray-sum-equals-k
//    Time complexity O(rows^2*cols)
//    https://leetcode.com/problems/number-of-submatrices-that-sum-to-target
//    Given a matrix and a target, return the number of non-empty submatrices that sum to target.
//    A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
//    Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is
//    different: for example, if x1 != x1'.
//    Example 1:
//    Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
//    Output: 4
//    Explanation: The four 1x1 submatrices that only contain 0.
//    Example 2:
//    Input: matrix = [[1,-1],[-1,1]], target = 0
//    Output: 5
//    Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
//    Example 3:
//    Input: matrix = [[904]], target = 0
//    Output: 0
public class SolutionDay49Fourth {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] prefixSum = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int left = col > 0 ? prefixSum[row][col - 1] : 0;
                int top = row > 0 ? prefixSum[row - 1][col] : 0;
                int topLeft = Math.min(col, row) > 0 ? prefixSum[row - 1][col - 1] : 0;
                prefixSum[row][col] = matrix[row][col] + left + top - topLeft;
            }
        }
        int ans = 0;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                Map<Integer, Integer> freq = new HashMap<>();
                freq.put(0, 1);
                for (int col = 0; col < cols; col++) {
                    int top = r1 > 0 ? prefixSum[r1 - 1][col] : 0;
                    int sum = prefixSum[r2][col] - top;
                    int diff = sum - target;
                    ans += freq.getOrDefault(diff, 0);
                    freq.put(sum, freq.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return ans;
    }
}
