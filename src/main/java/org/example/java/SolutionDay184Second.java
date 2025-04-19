package org.example.java;

//    medium #matrix
//    Time complexity is O(rows^cols)
//    Space complexity is O(rows^cols)
//    https://leetcode.com/problems/game-of-life
public class SolutionDay184Second {
    public static void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] board2 = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            System.arraycopy(board[row], 0, board2[row], 0, cols);
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int neighbours = findNeighbours(board2, row, col);
                int val = board2[row][col];
                if (val == 0 && neighbours == 3) board[row][col] = 1;
                if (val == 1 && (neighbours < 2 || neighbours > 3)) board[row][col] = 0;
            }
        }
    }

    private static int findNeighbours(int[][] board2, int row, int col) {
        int fRow = row == 0 ? 0 : row - 1;
        int fCol = col == 0 ? 0 : col - 1;
        int lRow = row == board2.length - 1 ? row : row + 1;
        int lCol = col == board2[0].length - 1 ? col : col + 1;
        int sum = 0;
        for (int i = fRow; i <= lRow; i++) {
            for (int j = fCol; j <= lCol; j++) {
                if (i == row && j == col) continue;
                sum += board2[i][j];
            }
        }
        return sum;
    }
}
