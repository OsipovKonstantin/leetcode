package org.example.java;

import java.util.*;

//hard #BFS #Priority Queue
//Time complexity is O(k+unique(k)*log(unique(k))+cells*log(cells))
//Space complexity is O(k+cells)
public class SolutionDay200 {
    public static int[] maxPoints(int[][] grid, int[] queries) {
        int len = queries.length;
        int rows = grid.length;
        int cols = grid[0].length;
        Map<Integer, List<Integer>> invertedMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            invertedMap.computeIfAbsent(queries[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> unique = new ArrayList<>(invertedMap.keySet());
        Collections.sort(unique);
        int uniqueLen = unique.size();

        int[] ans = new int[len];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        q.offer(new int[]{0, 0});
        int seenCounter = 0;
        boolean[][] seen = new boolean[rows][cols];
        seen[0][0] = true;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < uniqueLen; i++) {
            int curK = unique.get(i);
            while (!q.isEmpty()) {
                int[] curPair = q.peek();
                int curRow = curPair[0];
                int curCol = curPair[1];
                if (grid[curRow][curCol] >= curK) {
                    break;
                } else {
                    q.poll();
                    seen[curRow][curCol] = true;
                    seenCounter++;
                    for (int[] dir : dirs) {
                        int nextRow = curRow + dir[0];
                        int nextCol = curCol + dir[1];
                        int[] nextPair = new int[]{nextRow, nextCol};
                        if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= cols || seen[nextRow][nextCol])
                            continue;
                        seen[nextRow][nextCol] = true;
                        q.offer(nextPair);
                    }
                }
            }
            for (int index : invertedMap.get(curK)) {
                ans[index] = seenCounter;
            }
        }
        return ans;
    }
}
