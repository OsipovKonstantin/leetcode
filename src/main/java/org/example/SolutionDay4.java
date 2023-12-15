package org.example;

//        https://leetcode.com/problems/special-positions-in-a-binary-matrix
//        Given an m x n binary matrix mat, return the number of special positions in mat.
//        A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0
//        (rows and columns are 0-indexed).
//        Example 1:
//        Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
//        Output: 1
//        Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.
//        Example 2:
//        Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
//        Output: 3
//        Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
public class SolutionDay4 {
    public static int numSpecial(int[][] mat) {
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        for (int i = 0; i < m; i++) {
            int mCount = 0;
            int column = -1;
            for (int k = 0; k < n; k++) {
                if (mat[i][k] == 1) {
                    mCount++;
                    column = k;
                }
            }
            if (mCount != 1) {
                continue;
            }

            int nCount = 0;
            for (int j = 0; j < m; j++)
                if (mat[j][column] == 1)
                    nCount++;
            if (nCount == 1)
                count++;
        }
        return count;
    }
}
