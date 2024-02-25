package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//    hard #modified union find (disjoint set)
//    Time complexity is O(cells*log(cells)*cols), where cells are number of cells in matrix, cols are number of columns
//    Space complexity is O(cells)
//    https://leetcode.com/problems/last-day-where-you-can-still-cross
//    There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and
//    col representing the number of rows and columns in the matrix, respectively.
//    Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are
//    given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith
//    row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).
//    You want to find the last day that it is possible to walk from the top to the bottom by only walking on land
//    cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel
//    in the four cardinal directions (left, right, up, and down).
//    Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
//    Example 1:
//    Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
//    Output: 2
//    Explanation: The above image depicts how the matrix changes each day starting from day 0.
//    The last day where it is possible to cross from top to bottom is on day 2.
//    Example 2:
//    Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
//    Output: 1
//    Explanation: The above image depicts how the matrix changes each day starting from day 0.
//    The last day where it is possible to cross from top to bottom is on day 1.
//    Example 3:
//    Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
//    Output: 3
//    Explanation: The above image depicts how the matrix changes each day starting from day 0.
//    The last day where it is possible to cross from top to bottom is on day 3.
public class SolutionDay77Third {
    public static int latestDayToCross(int row, int col, int[][] cells) {
        int[][] dxy = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {1, -1}, {-1, -1}};
        UnionFind uf = new UnionFind(row, col);
        int n = cells.length;
        boolean[][] isWater = new boolean[row][col];
        for (int day = 0; day < n; day++) {
            int y = cells[day][0] - 1;
            int x = cells[day][1] - 1;
            isWater[y][x] = true;
            for (int i = 0; i < dxy.length; i++) {
                int nextY = y + dxy[i][1];
                int nextX = x + dxy[i][0];
                if (nextX >= 0 && nextX < col && nextY >= 0 && nextY < row && isWater[nextY][nextX]) {
                    if (uf.union(y * col + x, nextY * col + nextX)) return day;
                }
            }
        }
        return -1;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private Map<Integer, Set<Integer>> cols;
    private int colNumber;

    public UnionFind(int rowNumber, int colNumber) {
        parent = new int[rowNumber * colNumber];
        rank = new int[rowNumber * colNumber];
        this.colNumber = colNumber;
        cols = new HashMap<>();
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                int index = i * colNumber + j;
                parent[index] = index;
                cols.computeIfAbsent(index, key -> new HashSet<>()).add(j);
            }
        }
    }

    public int find(int a) {
        if (parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }

    public boolean union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA != pB) {
            int coveredCols;
            if (rank[pA] > rank[pB]) {
                parent[pB] = pA;
                cols.get(pA).addAll(cols.get(pB));
                coveredCols = cols.get(pA).size();
            } else if (rank[pA] < rank[pB]) {
                parent[pA] = pB;
                cols.get(pB).addAll(cols.get(pA));
                coveredCols = cols.get(pB).size();
            } else {
                parent[pB] = pA;
                rank[pA]++;
                cols.get(pA).addAll(cols.get(pB));
                coveredCols = cols.get(pA).size();
            }
            return coveredCols == colNumber;
        }
        return false;
    }
}
