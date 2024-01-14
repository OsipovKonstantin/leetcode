package org.example;


import java.util.ArrayList;
import java.util.List;

//    easy. #Pascal's triangle
//    https://leetcode.com/problems/pascals-triangle-ii
//    Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
//    In Pascal's triangle, each number is the sum of the two numbers directly above it
//    Example 1:
//    Input: rowIndex = 3
//    Output: [1,3,3,1]
//    Example 2:
//    Input: rowIndex = 0
//    Output: [1]
//    Example 3:
//    Input: rowIndex = 1
//    Output: [1,1]
public class SolutionDay35Fifth {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = null;
        List<Integer> temp;
        for (int i = 0; i < rowIndex + 1; i++) {
            temp = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                    continue;
                }
                temp.add(row.get(j - 1) + row.get(j));
            }
            row = temp;
        }
        return row;
    }
}
