package org.example;

import java.util.PriorityQueue;
import java.util.Queue;

//    medium #priorityqueue (Djkstra algorithm for finding shortest path)
//    Steps: use matrix as graph; traverse via priority queue; visited elements don't visit twice (use set or boolean[][])
//    push to priorityqueue nodes in all possible directions; priorityqueue store min path and coordinates so when
//    we reached end cell (y=m-1;x=n-1) we return length of path
//    https://leetcode.com/problems/path-with-minimum-effort
//    You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
//    where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0),
//    and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down,
//    left, or right, and you wish to find a route that requires the minimum effort.
//    A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
//    Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
//    Example 1:
//    Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
//    Output: 2
//    Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
//    This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
//    Example 2:
//    Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
//    Output: 1
//    Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is
//    better than route [1,3,5,3,5].
//    Example 3:
//    Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//    Output: 0
//    Explanation: This route does not require any effort.
public class SolutionDay44Third {
    public static int minimumEffortPath(int[][] heights) {
        //north, south, west, east
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{1, -1, 0, 0};
        int m = heights.length;
        int n = heights[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[m][n];
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] currNode = pq.poll();
            int cost = currNode[0];
            int y = currNode[1];
            int x = currNode[2];
            visited[y][x] = true;
            if (x == n - 1 && y == m - 1) {
                return cost;
            }
            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newY][newX]) {
                    continue;
                }
                pq.offer(new int[]{Math.max(cost, Math.abs(heights[newY][newX] - heights[y][x])), newY, newX});
            }
        }
        return -1;
    }
}
