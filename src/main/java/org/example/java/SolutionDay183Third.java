package org.example.java;

//    medium #matrix
//    Time complexity is O(rows*cols), where 'rows' is the number of rows in the matrix
//    and 'cols' is the number of columns in the matrix
//    Space complexity is O(1)
public class SolutionDay183Third {
    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRow = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int val = matrix[row][col];
                if (val == 0) {
                    matrix[0][col] = 0;
                    if (row != 0) matrix[row][0] = 0;
                    else firstRow = true;
                }
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) matrix[row][col] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int row = 1; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
        if (firstRow) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
