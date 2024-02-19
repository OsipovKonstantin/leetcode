package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//    medium #topological sort (Kahn's algorithm with indegrees).
//    Time complexity is O(n+m), where n is number of nodes and m is number of edges.
//    Space complexity is O(n+m) because indegrees store n elements and revertedGraph n elements with maximum m edges,
//    seen and queue also contain n elements
//    https://leetcode.com/problems/find-eventual-safe-states
//    There is a directed graph of n nodes with each node labeled from 0 to n - 1. The graph is represented by a
//    0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there
//    is an edge from node i to each node in graph[i].
//    A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting
//    from that node leads to a terminal node (or another safe node).
//    Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
//    Example 1:
//    Illustration of graph
//    Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//    Output: [2,4,5,6]
//    Explanation: The given graph is shown above.
//    Nodes 5 and 6 are terminal nodes as there are no outgoing edges from either of them.
//    Every path starting at nodes 2, 4, 5, and 6 all lead to either node 5 or 6.
//    Example 2:
//    Input: graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//    Output: [4]
//    Explanation:
//    Only node 4 is a terminal node, and every path starting at node 4 leads to node 4.
public class SolutionDay71Third {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegrees = new int[n];
        List<List<Integer>> revertedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            revertedGraph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int num : graph[i]) {
                revertedGraph.get(num).add(i);
                indegrees[i]++;
            }
        }

        boolean[] seen = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int zeroIndegrees = q.poll();
            seen[zeroIndegrees] = true;
            for (int index : revertedGraph.get(zeroIndegrees)) {
                indegrees[index]--;
                if (indegrees[index] == 0) q.offer(index);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (seen[i]) ans.add(i);
        }
        return ans;
    }
}
