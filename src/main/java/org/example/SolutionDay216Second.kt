package org.example

//    medium #depth-first search #kotlin
//    Time complexity is O(rows*cols), where rows and cols denote the dimensions of the matrix board
//    Space complexity is O(rows*cols)
//    https://leetcode.com/problems/surrounded-regions
class SolutionDay216Second {
    companion object {
        fun solve(board: Array<CharArray>) {
            val rows = board.size
            val cols = board[0].size
            val board2 = Array(rows) { CharArray(cols) }
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    board2[row][col] = board[row][col]
                }
            }
            val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
            for (row in 0 until rows) {
                if (board2[row][0] == 'O') dfs(row, 0, board2, dirs, rows, cols)
                if (board2[row][cols - 1] == 'O') dfs(row, cols - 1, board2, dirs, rows, cols)
            }
            for (col in 0 until cols) {
                if (board2[0][col] == 'O') dfs(0, col, board2, dirs, rows, cols)
                if (board2[rows - 1][col] == 'O') dfs(rows - 1, col, board2, dirs, rows, cols)
            }
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    if (board[row][col] == 'O' && board[row][col] == board2[row][col]) board[row][col] = 'X'
                }
            }
        }

        private fun dfs(row: Int, col: Int, board2: Array<CharArray>, dirs: Array<IntArray>, rows: Int, cols: Int) {
            board2[row][col] = 'X'
            for (dir in dirs) {
                val nextRow = row + dir[0]
                val nextCol = col + dir[1]
                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || board2[nextRow][nextCol] == 'X') continue
                dfs(nextRow, nextCol, board2, dirs, rows, cols)
            }
        }
    }
}