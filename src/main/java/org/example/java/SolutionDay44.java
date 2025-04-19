package org.example.java;

import java.util.LinkedList;
import java.util.Queue;

//    hard #bitmask (used for numbers less than 32 - int format or 64 - long format) #queue #Breadth First Search (BFS)
//    Steps:
//    create bitmask
//    create variable seen = boolean[bitmask][n]. Column is last seen node
//    create queue q for nodes of graph
//    traverse nodes from queue with BFS
//    inside loop for neighbour traversal. Continue if node was seen before
//    after loops return -1. It means that there is no way to traverse all nodes
//    https://leetcode.com/problems/shortest-path-visiting-all-nodes
//    You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where
//    graph[i] is a list of all the nodes connected with node i by an edge.
//    Return the length of the shortest path that visits every node. You may start and stop at any node, you may
//    revisit nodes multiple times, and you may reuse edges.
//    Example 1:
//    Input: graph = [[1,2,3],[0],[0],[0]]
//    Output: 4
//    Explanation: One possible path is [1,0,2,0,3]
//    Example 2:
//    Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
//    Output: 4
//    Explanation: One possible path is [0,1,4,2,3]
public class SolutionDay44 {
    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int maxBitmask = (1 << n) - 1;
        boolean[][] seen = new boolean[maxBitmask + 1][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new int[]{i, 1 << i, 0});
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0];
            int currBitmask = curr[1];
            int currStep = curr[2];

            if (currBitmask == maxBitmask) {
                return currStep;
            }
            for (int nextNode : graph[currNode]) {
                int nextBitmask = currBitmask | (1 << nextNode);
                if (seen[nextBitmask][nextNode]) {
                    continue;
                }
                q.offer(new int[]{nextNode, nextBitmask, currStep + 1});
                seen[nextBitmask][nextNode] = true;
            }
        }
        return -1;
    }
}
