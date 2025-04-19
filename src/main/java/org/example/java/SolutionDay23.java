package org.example.java;

import com.github.javaparser.utils.Pair;

import java.util.ArrayList;
import java.util.List;

//    medium. Decision - without sort of every row (approach 3)
//    https://leetcode.com/problems/largest-submatrix-with-rearrangements
//    You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix
//    in any order.
//    Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering
//    the columns optimally.
//    Example 1:
//    Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
//    Output: 4
//    Explanation: You can rearrange the columns as shown above.
//    The largest submatrix of 1s, in bold, has an area of 4.
//    Example 2:
//    Input: matrix = [[1,0,1,0,1]]
//    Output: 3
//    Explanation: You can rearrange the columns as shown above.
//    The largest submatrix of 1s, in bold, has an area of 3.
//    Example 3:
//    Input: matrix = [[1,1,0],[1,0,1]]
//    Output: 2
//    Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger
//    than an area of 2.
public class SolutionDay23 {
    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList<>();
        int res = 0;

        for (int i = 0; i < m; i++) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];
            for (Pair<Integer, Integer> pair : prevHeights) {
                int col = pair.b;
                int height = pair.a;
                if (matrix[i][col] != 0) {
                    heights.add(new Pair(height + 1, col));
                    seen[col] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (!seen[j] && matrix[i][j] == 1) {
                    heights.add(new Pair(1, j));
                }
            }
            for (int k = 0; k < heights.size(); k++) {
                int height = heights.get(k).a;
                res = Math.max(res, (k + 1) * height);
            }
            prevHeights = heights;
        }
        return res;
    }
}
