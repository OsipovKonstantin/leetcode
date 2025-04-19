package org.example.java;

//    medium #matrix
//    Time complexity is O(len^2), where len is the number of rows/cols in matrix
//    Space complexity is O(1)
//    https://leetcode.com/problems/rotate-image
public class SolutionDay183 {
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int row = 0; row < (len % 2 == 1 ? len / 2 + 1 : len / 2); row++) {
            for (int col = row; col < len - 1 - row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[len - 1 - col][row];
                matrix[len - col - 1][row] = matrix[len - 1 - row][len - 1 - col];
                matrix[len - 1 - row][len - 1 - col] = matrix[col][len - 1 - row];
                matrix[col][len - 1 - row] = temp;
            }
        }
    }
}
