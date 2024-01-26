package org.example;

import java.util.ArrayList;
import java.util.List;

//    easy #Pascal's triangle #dynamic programming
//    https://leetcode.com/problems/pascals-triangle
//    Given an integer numRows, return the first numRows of Pascal's triangle.
//    In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//    Example 1:
//    Input: numRows = 5
//    Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//    Example 2:
//    Input: numRows = 1
//    Output: [[1]]
public class SolutionDay47Second {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        ans.add(new ArrayList<>(curr));
        for (int i = 1; i < numRows; i++) {
            curr.add(1);
            for (int j = i - 1; j >= 1; j--) {
                curr.set(j, curr.get(j) + curr.get(j - 1));
            }
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    }
}
