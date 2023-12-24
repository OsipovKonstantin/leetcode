package org.example;

import com.github.javaparser.utils.Pair;

import java.util.HashSet;
import java.util.Set;

//    https://leetcode.com/problems/path-crossing
//    Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
//    Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
//    Example 1:
//    Input: path = "NES"
//    Output: false
//    Explanation: Notice that the path doesn't cross any point more than once.
//    Example 2:
//    Input: path = "NESWW"
//    Output: true
//    Explanation: Notice that the path visits the origin twice.
class SolutionDay13 {
    public static boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<Pair<Integer, Integer>> pathSet = new HashSet<>();
        for (char c : path.toCharArray()) {
            pathSet.add(new Pair(x, y));
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }
            if (pathSet.contains(new Pair(x, y))) {
                return true;
            }
        }
        return false;
    }
}
