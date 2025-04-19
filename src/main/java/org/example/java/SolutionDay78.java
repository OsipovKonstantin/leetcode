package org.example.java;

import com.github.javaparser.utils.Pair;

import java.util.*;

//    hard (very hard) #breadth first search #bitmask
//    Time complexity is O(cells*2^keys), where cells is size of matrix (rows*cols), keys in number of keys
//    Space complexity is O(cells*2^keys)
//    https://leetcode.com/problems/shortest-path-to-get-all-keys
//    You are given an m x n grid grid where:
//    '.' is an empty cell.
//    '#' is a wall.
//    '@' is the starting point.
//    Lowercase letters represent keys.
//    Uppercase letters represent locks.
//    You start at the starting point and one move consists of walking one space in one of the four cardinal directions.
//    You cannot walk outside the grid, or walk into a wall.
//    If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its corresponding key.
//    For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters of the
//    English alphabet in the grid. This means that there is exactly one key for each lock, and one lock for each key;
//    and also that the letters used to represent the keys and locks were chosen in the same order as the English
//    alphabet.
//    Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
//    Example 1:
//    Input: grid = ["@.a..","###.#","b.A.B"]
//    Output: 8
//    Explanation: Note that the goal is to obtain all the keys not to open all the locks.
//    Example 2:
//    Input: grid = ["@..aA","..B#.","....b"]
//    Output: 6
//    Example 3:
//    Input: grid = ["@Aa"]
//    Output: -1
public class SolutionDay78 {
    public static int shortestPathAllKeys(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int startX = -1;
        int startY = -1;
        Set<Character> keys = new HashSet<>();
        Set<Character> locks = new HashSet<>();
        int allKeys = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char[] cs = grid[i].toCharArray();
                if (cs[j] >= 'a' && cs[j] <= 'f') {
                    keys.add(cs[j]);
                    allKeys += 1 << (cs[j] - 'a');
                } else if (cs[j] >= 'A' && cs[j] <= 'F') locks.add(cs[j]);
                else if (cs[j] == '@') {
                    startX = j;
                    startY = i;
                }
            }
        }
        Map<Integer, Set<Pair<Integer, Integer>>> seen = new HashMap<>();
        Queue<int[]> q = new LinkedList<>();
        seen.computeIfAbsent(0, key -> new HashSet<>()).add(new Pair(startX, startY));
        q.offer(new int[]{startX, startY, 0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int keyState = cur[2];
            int distance = cur[3];
            for (int[] move : moves) {
                int nextX = x + move[0];
                int nextY = y + move[1];
                if (nextX >= 0 && nextX < cols && nextY >= 0 && nextY < rows && grid[nextY].charAt(nextX) != '#') {
                    char c = grid[nextY].charAt(nextX);
                    if (keys.contains(c)) {
                        if ((keyState & 1 << (c - 'a')) != 0) continue;
                        int nextKeyState = keyState | 1 << (c - 'a');
                        if (nextKeyState == allKeys) return distance + 1;
                        seen.computeIfAbsent(nextKeyState, key -> new HashSet<>()).add(new Pair(nextX, nextY));
                        q.offer(new int[]{nextX, nextY, nextKeyState, distance + 1});
                    }
                    if (locks.contains(c) && (keyState & (1 << (c - 'A'))) == 0) continue;
                    else if (!seen.get(keyState).contains(new Pair(nextX, nextY))) {
                        seen.get(keyState).add(new Pair(nextX, nextY));
                        q.offer(new int[]{nextX, nextY, keyState, distance + 1});
                    }
                }
            }
        }
        return -1;
    }
}
