package org.example.java;

//    medium #binary search. Time complexity is O(log(n+m)), where n - is number of rows, n is number of columns
//    in matrix. Space complexity is O(1)
//    https://leetcode.com/problems/search-a-2d-matrix
//    You are given an m x n integer matrix matrix with the following two properties:
//    Each row is sorted in non-decreasing order.
//    The first integer of each row is greater than the last integer of the previous row.
//    Given an integer target, return true if target is in matrix or false otherwise.
//    You must write a solution in O(log(m * n)) time complexity.
//    Example 1:
//    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//    Output: true
//    Example 2:
//    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//    Output: false
public class SolutionDay59 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;
        while (top < bottom) {
            int mid = top + (bottom - top) / 2;
            if (target == matrix[mid][0]) return true;
            else if (target > matrix[mid][0] && target < matrix[bottom][0]) {
                top = mid;
                bottom--;
            } else if (target >= matrix[bottom][0]) top = bottom;
            else bottom = mid - 1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == matrix[top][mid]) return true;
            else if (target > matrix[top][mid]) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
