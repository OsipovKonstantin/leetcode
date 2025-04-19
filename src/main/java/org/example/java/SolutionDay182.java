package org.example.java;

//    medium #math
//    Time complexity is O(1)
//    Space complexity is O(1)
//    https://leetcode.com/problems/count-total-number-of-colored-cells
public class SolutionDay182 {
    public static long coloredCells(int n) {
        if (n == 1) return 1;
        n--;
        return 1 + (n * 4L + 4) / 2 * n;
    }
}
