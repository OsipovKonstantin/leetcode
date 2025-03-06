package org.example;

//    medium #matrix #math
//    Time complexity is O(len^2), where len^2 is the number of cells in grid
//    Space complexity is O(len^2)
//    https://leetcode.com/problems/find-missing-and-repeated-values
public class SolutionDay183Second {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length;
        int[] ans = new int[2];
        int sum = 0;
        boolean[] seen = new boolean[len * len + 1];
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int val = grid[row][col];
                if (seen[val]) ans[0] = val;
                seen[val] = true;
                sum += val;
            }
        }
        ans[1] = (1 + len * len) * len * len / 2 - (sum - ans[0]);
        return ans;
    }
}
