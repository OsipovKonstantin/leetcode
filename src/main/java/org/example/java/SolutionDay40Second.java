package org.example.java;

//    medium. #dynamic programming with two 1D arrays. Space complexity O(n)
//    https://leetcode.com/problems/minimum-falling-path-sum
//    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
//    A falling path starts at any element in the first row and chooses the element in the next row that is either
//    directly below or diagonally left/right. Specifically, the next element from position (row, col) will be
//    (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
//    Example 1:
//    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
//    Output: 13
//    Explanation: There are two falling paths with a minimum sum as shown.
//    Example 2:
//    Input: matrix = [[-19,57],[-40,-5]]
//    Output: -59
//    Explanation: The falling path with a minimum sum is shown.
public class SolutionDay40Second {
    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        int[] prev = matrix[0];
        int[] curr = new int[n];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = prev[j];
                if (j > 0 && temp > prev[j - 1]) {
                    temp = prev[j - 1];
                }
                if (j < n - 1 && temp > prev[j + 1]) {
                    temp = prev[j + 1];
                }
                curr[j] = temp + matrix[i][j];
            }
            prev = curr;
            curr = new int[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int minSum : prev) {
            ans = Math.min(ans, minSum);
        }
        return ans;
    }
}
