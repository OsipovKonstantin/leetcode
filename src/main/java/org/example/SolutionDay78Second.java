package org.example;

import com.github.javaparser.utils.Pair;

import java.util.*;

//    medium #Dijkstra algorithm
//    Time complexity is O(m+nlogn), where m is number of edges, n is number of nodes. Each operation of priority queue
//    require logn operations and we traverse through n nodes in priority queue in worst case
//    Space complexity is O(m+n) because graph store edges (m), seen store n elements and priority queue also n elements
//    https://leetcode.com/problems/path-with-maximum-probability
//    You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list where edges[i] =
//    [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge
//    succProb[i].
//    Given two nodes start and end, find the path with the maximum probability of success to go from start to end and
//    return its success probability.
//    If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct
//    answer by at most 1e-5.
//    Example 1:
//    Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
//    Output: 0.25000
//    Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other
//    has 0.5 * 0.5 = 0.25.
//    Example 2:
//    Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
//    Output: 0.30000
//    Example 3:
//    Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
//    Output: 0.00000
//    Explanation: There is no path between 0 and 2.
public class SolutionDay78Second {
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double probability = succProb[i];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new Pair(to, probability));
            graph.computeIfAbsent(to, key -> new ArrayList<>()).add(new Pair(from, probability));
        }
        boolean[] seen = new boolean[n];
        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>((x, y) -> Double.compare(y.b, x.b));
        q.offer(new Pair(start_node, 1.0));
        while (!q.isEmpty()) {
            Pair<Integer, Double> cur = q.poll();
            int node = cur.a;
            double prob = cur.b;
            seen[node] = true;
            if (node == end_node) return prob;
            if (!graph.containsKey(node)) {
                continue;
            }
            for (Pair<Integer, Double> next : graph.get(node)) {
                int nextNode = next.a;
                double nextProb = next.b;
                if (!seen[nextNode]) {
                    q.offer(new Pair(nextNode, prob * nextProb));
                }
            }
        }
        return 0;
    }
}
