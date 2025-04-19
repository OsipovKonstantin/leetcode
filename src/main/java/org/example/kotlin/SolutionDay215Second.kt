package org.example.kotlin

import java.util.*

//    medium #breadth-first search #kotlin
//    Time complexity is O(rows*cols), where rows and cols are sizes of 2D grid
//    Space complexity is O(rows*cols)
//    https://leetcode.com/problems/number-of-islands
class SolutionDay215Second {
    companion object {
        fun numIslands(grid: Array<CharArray>): Int {
            val rows = grid.size
            val cols = grid[0].size
            val visited = Array(rows) { BooleanArray(cols) }
            val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
            var ans = 0
            val q: Queue<IntArray> = LinkedList()
            for (row in 0 until rows) {
                for (col in 0 until cols) {
                    if (visited[row][col] || grid[row][col] == '0') continue
                    ans++
                    q.offer(intArrayOf(row, col))
                    visited[row][col] = true
                    while (q.isNotEmpty()) {
                        val size = q.size
                        for (i in 0 until size) {
                            val cur = q.poll()
                            val curRow = cur[0]
                            val curCol = cur[1]
                            for (dir in dirs) {
                                val nextRow = curRow + dir[0]
                                val nextCol = curCol + dir[1]
                                if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols ||
                                    visited[nextRow][nextCol] || grid[nextRow][nextCol] == '0') continue
                                q.offer(intArrayOf(nextRow, nextCol))
                                visited[nextRow][nextCol] = true
                            }
                        }
                    }
                }
            }
            return ans
        }
    }
}