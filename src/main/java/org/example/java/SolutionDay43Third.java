package org.example.java;

import java.util.Arrays;

//    easy #sorting #pairs (here - powerAndIndex consists at index 0 - number of 1s, at index 1 - index of row in
//    array mat)
//    https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
//    You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians).
//    The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all
//    the 0's in each row.
//    A row i is weaker than a row j if one of the following is true:
//    The number of soldiers in row i is less than the number of soldiers in row j.
//    Both rows have the same number of soldiers and i < j.
//    Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.
//    Example 1:
//    Input: mat =
//    [[1,1,0,0,0],
//     [1,1,1,1,0],
//     [1,0,0,0,0],
//     [1,1,0,0,0],
//     [1,1,1,1,1]],
//    k = 3
//    Output: [2,0,3]
//    Explanation:
//    The number of soldiers in each row is:
//    - Row 0: 2
//    - Row 1: 4
//    - Row 2: 1
//    - Row 3: 2
//    - Row 4: 5
//    The rows ordered from weakest to strongest are [2,0,3,1,4].
//    Example 2:
//    Input: mat =
//    [[1,0,0,0],
//     [1,1,1,1],
//     [1,0,0,0],
//     [1,0,0,0]],
//    k = 2
//    Output: [0,2]
//    Explanation:
//    The number of soldiers in each row is:
//    - Row 0: 1
//    - Row 1: 4
//    - Row 2: 1
//    - Row 3: 1
//    The rows ordered from weakest to strongest are [0,2,3,1].
public class SolutionDay43Third {
    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] powerAndIndex = new int[m][2];
        for (int i = 0; i < m; i++) {
            powerAndIndex[i][1] = i;
            for (int j = 0; j < n; j++) {
                powerAndIndex[i][0] += mat[i][j];
            }
        }
        Arrays.sort(powerAndIndex, (r1, r2) -> {
            if (r1[0] != r2[0]) {
                return r1[0] - r2[0];
            }
            return r1[1] - r2[1];
        });
        int[] ans = new int[k];
        for (int l = 0; l < k; l++) {
            ans[l] = powerAndIndex[l][1];
        }
        return ans;
    }
}
