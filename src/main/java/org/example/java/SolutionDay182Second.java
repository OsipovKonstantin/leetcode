package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    medium #matrix #simulation
//    Time complexity is O(n*m), where n is the number of rows and m is the number of cols
//    Space complexity is O(1) if we don't count space of ans (answer) arraylist
//    https://leetcode.com/problems/spiral-matrix
public class SolutionDay182Second {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowSteps = matrix.length - 1;
        int colSteps = matrix[0].length;
        int curRow = 0;
        int curCol = -1;
        List<Integer> ans = new ArrayList<>();
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int curDir = 0;
        while (true) {
            if (colSteps == 0 && curDir % 2 == 0) break;
            if (rowSteps == 0 && curDir % 2 == 1) break;
            for (int steps = 0; steps < (curDir % 2 == 0 ? colSteps : rowSteps); steps++) {
                curRow += dir[curDir % 4][0];
                curCol += dir[curDir % 4][1];
                ans.add(matrix[curRow][curCol]);
            }
            if (curDir % 2 == 0) colSteps--;
            else rowSteps--;
            curDir++;
        }
        return ans;
    }
}
