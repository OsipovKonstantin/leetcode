package org.example.java;

import java.util.*;

//    hard(really hard) #Minimum spanning tree (MST)
//    Very slow solution, but I wrote it myself during 4.5 hours
//    https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree
//    Given a weighted undirected connected graph with n vertices numbered from 0 to n - 1, and an array edges where
//    edges[i] = [ai, bi, weighti] represents a bidirectional and weighted edge between nodes ai and bi. A minimum
//    spanning tree (MST) is a subset of the graph's edges that connects all vertices without cycles and with the
//    minimum possible total edge weight.
//    Find all the critical and pseudo-critical edges in the given graph's minimum spanning tree (MST). An MST edge
//    whose deletion from the graph would cause the MST weight to increase is called a critical edge. On the other
//    hand, a pseudo-critical edge is that which can appear in some MSTs but not all.
//    Note that you can return the indices of the edges in any order.
//    Example 1:
//    Input: n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
//    Output: [[0,1],[2,3,4,5]]
//    Explanation: The figure above describes the graph.
//    The following figure shows all the possible MSTs:
//    Notice that the two edges 0 and 1 appear in all MSTs, therefore they are critical edges, so we return them in
//    the first list of the output.
//    The edges 2, 3, 4, and 5 are only part of some MSTs, therefore they are considered pseudo-critical edges. We add
//    them to the second list of the output.
//    Example 2:
//    Input: n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
//    Output: [[],[0,1,2,3]]
//    Explanation: We can observe that since all 4 edges have equal weight, choosing any 3 edges from the given 4 will
//    yield an MST. Therefore all 4 edges are pseudo-critical.
public class SolutionDay55Third {
    public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int edgeNum = edges.length;

        //create graph and fill
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int edge = 0; edge < edgeNum; edge++) {
            int first = edges[edge][0];
            int second = edges[edge][1];
            graph.computeIfAbsent(first, key -> new ArrayList<>()).add(new int[]{second, edge, edges[edge][2]});
            graph.computeIfAbsent(second, key -> new ArrayList<>()).add(new int[]{first, edge, edges[edge][2]});
        }

        //find MST weight. It will be used further to find critical and pseudocritical edges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        PriorityQueue<int[]> excludePQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int includedEdge = 0;

        Set<Integer> visited = new HashSet<>();
        Set<Integer> excludeVisited = new HashSet<>();
        Set<Integer> includeVisited = new HashSet<>();

        visited.add(0);
        for (int[] node : graph.get(0))
            pq.offer(node);
        int mstWeight = MST(n, edges, graph, pq, visited);

        //create beforehand ans list with critical and pseudocritical edges
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> critical = new HashSet<>();
        Set<Integer> pseudoCritical = new HashSet<>();

        //find critical and pseudocritical edges
        for (int i = 0; i < n; i++) {
            List<int[]> nodeList = graph.get(i);
            int size = nodeList.size();
            if (size == 1) {
                critical.add(nodeList.get(0)[1]);
            } else {
                for (int j = 0; j < size; j++) {
                    int[] temp = nodeList.get(j);
                    int edge = temp[1];
                    excludePQ.clear();
                    excludeVisited.clear();
                    excludeVisited.add(i);
                    for (int[] node : nodeList)
                        if (!Arrays.equals(node, temp)) excludePQ.offer(node);
                    if (MST(n, edges, graph, excludePQ, excludeVisited) != mstWeight)
                        critical.add(edge);

                    PriorityQueue<int[]> includePQ = new PriorityQueue<>((a, b) -> {
                        if (a[1] == edge) return -1;
                        else if (b[1] == edge) return 1;
                        else return a[2] - b[2];
                    });
                    includeVisited.clear();
                    includeVisited.add(i);
                    for (int[] node : nodeList)
                        includePQ.offer(node);
                    if (MST(n, edges, graph, includePQ, includeVisited) == mstWeight)
                        if (!critical.contains(edge)) pseudoCritical.add(edge);
                }
            }
        }

        List<Integer> criticalList = new ArrayList<>(critical);
        List<Integer> pseudoCriticalList = new ArrayList<>(pseudoCritical);
        Collections.sort(criticalList);
        Collections.sort(pseudoCriticalList);
        ans.add(criticalList);
        ans.add(pseudoCriticalList);
        return ans;
    }

    private static int MST(int n, int[][] edges, Map<Integer, List<int[]>> graph, PriorityQueue<int[]> pq,
                           Set<Integer> visited) {
        int mstWeight = 0;
        while (visited.size() != n && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int edge = cur[1];
            int weight = cur[2];
            if (visited.contains(node)) {
                continue;
            }
            mstWeight += weight;
            visited.add(node);
            for (int[] params : graph.get(node)) {
                int newNode = params[0];
                int newEdge = params[1];
                int newWeight = edges[newEdge][2];
                if (!visited.contains(newNode)) {
                    pq.offer(new int[]{newNode, newEdge, newWeight});
                }
            }
        }
        return mstWeight;
    }
}
