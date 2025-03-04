package org.example;

//    medium #set #matrix
//    Time complexity is O(9*9) or O(1), where 9 is number of rows and cols
//    Space complexity is O(1)
//    https://leetcode.com/problems/valid-sudoku
public class SolutionDay181Second {
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] seenRow = new boolean[9][10];
        boolean[][] seenCol = new boolean[9][10];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];
                if (cur == '.') continue;
                if (seenRow[row][cur - '0']) return false;
                if (seenCol[col][cur - '0']) return false;
                seenRow[row][cur - '0'] = true;
                seenCol[col][cur - '0'] = true;
            }
        }
        for (int row = 0; row < 9; row = row + 3) {
            for (int col = 0; col < 9; col = col + 3) {
                boolean[] seen = new boolean[10];
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        char cur = board[i][j];
                        if (cur == '.') continue;
                        if (seen[cur - '0']) return false;
                        seen[cur - '0'] = true;
                    }
                }
            }
        }
        return true;
    }
}
