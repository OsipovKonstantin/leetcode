package org.example;

import java.util.Arrays;

//    medium #sorting #prefixSum
//    Time complexity is O(nlogn), where n is the number of elements in grid (rows*cols)
//    Space complexity is O(n)
//    https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid
public class SolutionDay198 {
    public static int minOperations(int[][] grid, int x) {
        int rows = grid.length;
        int cols = grid[0].length;
        int n = rows * cols;
        int[] nums = new int[n];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                nums[row * cols + col] = grid[row][col];
                if ((grid[row][col] - grid[0][0]) % x != 0) return -1;
            }
        }
        Arrays.sort(nums);
        int sumEnd = 0;
        for (int i = 1; i < n; i++) {
            sumEnd += (nums[i] - nums[0]);
        }
        int sumStart = 0;
        int ansMultX = sumEnd;
        for (int i = 1; i < n; i++) {
            sumStart += i * (nums[i] - nums[i - 1]);
            sumEnd -= (n - i) * (nums[i] - nums[i - 1]);
            ansMultX = Math.min(ansMultX, sumStart + sumEnd);
        }
        return ansMultX / x;
    }
}
