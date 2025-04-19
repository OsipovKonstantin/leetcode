package org.example.datastructures;

import com.github.javaparser.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//    hard. Dijkstra's Algorithm (Алгоритм голландца Дейкстры для поиска кратчайшего пути). Priority Queue. Pair
//    https://leetcode.com/problems/design-graph-with-shortest-path-calculator
//     There is a directed weighted graph that consists of n nodes numbered from 0 to n - 1. The edges of the graph are
//     initially represented by the given array edges where edges[i] = [fromi, toi, edgeCosti] meaning that there is
//     an edge from fromi to toi with the cost edgeCosti.
//    Implement the Graph class:
//    Graph(int n, int[][] edges) initializes the object with n nodes and the given edges.
//    addEdge(int[] edge) adds an edge to the list of edges where edge = [from, to, edgeCost]. It is guaranteed that
//    there is no edge between the two nodes before adding this one.
//    int shortestPath(int node1, int node2) returns the minimum cost of a path from node1 to node2. If no path exists,
//    return -1. The cost of a path is the sum of the costs of the edges in the path.
//    Example 1:
//    Input
//    ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
//    [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
//    Output
//    [null, 6, -1, null, 6]
//    Explanation
//    Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
//    g.shortestPath(3, 2); // return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2
//    with a total cost of 3 + 2 + 1 = 6.
//    g.shortestPath(0, 3); // return -1. There is no path from 0 to 3.
//    g.addEdge([1, 3, 4]); // We add an edge from node 1 to node 3, and we get the second diagram above.
//    g.shortestPath(0, 3); // return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
public class Graph {
    List<List<Pair<Integer, Integer>>> fromToCost = new ArrayList<>();

    public Graph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            fromToCost.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            fromToCost.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }
    }

    public void addEdge(int[] edge) {
        fromToCost.get(edge[0]).add(new Pair(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((p1, p2) -> p1.a - p2.a);
        pq.offer(new Pair(0, node1));
        int[] costArray = new int[100];
        Arrays.fill(costArray, Integer.MAX_VALUE);
        costArray[node1] = 0;

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.poll();
            int currCost = curr.a;
            int currNode = curr.b;

            if (currCost > costArray[currNode]) {
                continue;
            }
            if (currNode == node2) {
                return costArray[currNode];
            }
            for (Pair<Integer, Integer> nextPair : fromToCost.get(currNode)) {
                int nextNode = nextPair.a;
                int nextCost = nextPair.b + currCost;
                if (nextCost < costArray[nextNode]) {
                    costArray[nextNode] = nextCost;
                    pq.offer(new Pair(nextCost, nextNode));
                }
            }
        }
        return -1;
    }
}
