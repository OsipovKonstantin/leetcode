package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//    medium (but really hard) #BFS #binary search
//    Time complexity is O(n^2*logn) because of binary search
//    Space complexity is O(n^2)
//    https://leetcode.com/problems/find-the-safest-path-in-a-grid
//    You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
//    A cell containing a thief if grid[r][c] = 1
//    An empty cell if grid[r][c] = 0
//    You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid,
//    including cells containing thieves.
//    The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the
//    path to any thief in the grid.
//    Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
//    An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it
//    exists.
//    The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val| denotes
//    the absolute value of val.
//    Example 1:
//    Input: grid = [[1,0,0],[0,0,0],[0,0,1]]
//    Output: 0
//    Explanation: All paths from (0, 0) to (n - 1, n - 1) go through the thieves in cells (0, 0) and (n - 1, n - 1).
//    Example 2:
//    Input: grid = [[0,0,1],[0,0,0],[0,0,0]]
//    Output: 2
//    Explanation: The path depicted in the picture above has a safeness factor of 2 since:
//    - The closest cell of the path to the thief at cell (0, 2) is cell (0, 0). The distance between them is
//    | 0 - 0 | + | 0 - 2 | = 2.
//    It can be shown that there are no other paths with a higher safeness factor.
//    Example 3:
//    Input: grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
//    Output: 2
//    Explanation: The path depicted in the picture above has a safeness factor of 2 since:
//    - The closest cell of the path to the thief at cell (0, 3) is cell (1, 2). The distance between them is
//    | 0 - 1 | + | 3 - 2 | = 2.
//    - The closest cell of the path to the thief at cell (3, 0) is cell (3, 2). The distance between them is
//    | 3 - 3 | + | 0 - 2 | = 2.
//    It can be shown that there are no other paths with a higher safeness factor.
public class SolutionDay126 {
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        Queue<int[]> thieves = new LinkedList<>();
        boolean[][] viewed = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid.get(row).get(col) == 1) {
                    thieves.offer(new int[]{row, col});
                    viewed[row][col] = true;
                }
            }
        }
        int[][] distanceGrid = new int[n][n];
        int step = 0;
        while (!thieves.isEmpty()) {
            int size = thieves.size();
            for (int i = 0; i < size; i++) {
                int[] cur = thieves.poll();
                int curRow = cur[0];
                int curCol = cur[1];
                distanceGrid[curRow][curCol] = step;
                for (int[] dir : dirs) {
                    int nextRow = curRow + dir[0];
                    int nextCol = curCol + dir[1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n
                            && !viewed[nextRow][nextCol]) {
                        thieves.offer(new int[]{nextRow, nextCol});
                        viewed[nextRow][nextCol] = true;
                    }
                }
            }
            step++;
        }

        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = right - (right - left) / 2;
            boolean[][] seen = new boolean[n][n];
            Queue<int[]> q = new LinkedList<>();
            if (distanceGrid[0][0] >= mid) {
                q.offer(new int[]{0, 0});
                seen[0][0] = true;
            }
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    int curRow = cur[0];
                    int curCol = cur[1];
                    for (int[] dir : dirs) {
                        int nextRow = curRow + dir[0];
                        int nextCol = curCol + dir[1];
                        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n &&
                                !seen[nextRow][nextCol] && distanceGrid[nextRow][nextCol] >= mid) {
                            q.offer(new int[]{nextRow, nextCol});
                            seen[nextRow][nextCol] = true;
                        }
                    }
                }
            }
            if (seen[n - 1][n - 1]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
