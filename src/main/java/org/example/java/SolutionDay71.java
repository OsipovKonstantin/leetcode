package org.example.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    medium #graph (topological sort with indegrees).
//    Time complexity is O(n*(n+m)), where n is number of courses, m is length of prerequisites array
//    Space complexity is O(n+m)
//    https://leetcode.com/problems/course-schedule
//    There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
//    prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//    Return true if you can finish all courses. Otherwise, return false.
//    Example 1:
//    Input: numCourses = 2, prerequisites = [[1,0]]
//    Output: true
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0. So it is possible.
//    Example 2:
//    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//    Output: false
//    Explanation: There are a total of 2 courses to take.
//    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
//    So it is impossible.
public class SolutionDay71 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegrees = new int[numCourses];

        for (int[] pre : prerequisites) {
            map.computeIfAbsent(pre[1], key -> new ArrayList<>()).add(pre[0]);
            indegrees[pre[0]]++;
        }
        boolean[] visited = new boolean[numCourses];
        boolean found = true;
        while (found) {
            found = false;
            int zeroIndegrees = -1;
            for (int i = 0; i < numCourses; i++) {
                if (!visited[i] && indegrees[i] == 0) {
                    zeroIndegrees = i;
                    visited[i] = true;
                    found = true;
                    break;
                }
            }
            if (map.containsKey(zeroIndegrees))
                for (int index : map.get(zeroIndegrees))
                    indegrees[index]--;
        }
        for (int i = 0; i < numCourses; i++)
            if (!visited[i]) return false;
        return true;
    }
}
