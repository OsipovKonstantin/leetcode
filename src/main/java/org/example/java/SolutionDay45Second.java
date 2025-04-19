package org.example.java;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//    medium (еру algorithm is really specific, very similar to Dijkstra's algo, except for the condition to stop the
//    while loop. Here, it visits all nodes) #Prim's algorithm. This algorithm is used to find the shortest paths that
//    connect all nodes, forming a minimum spanning tree (MST) If I were to explain it to children: this algorithm
//    allows us to connect houses with roads that have the shortest length
//    https://leetcode.com/problems/min-cost-to-connect-all-points
//    You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] =
//    [xi, yi]. The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them:
//    |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
//    Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
//    between any two points.
//    Example 1:
//    Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//    Output: 20
//    Explanation:
//    We can connect the points as shown above to get the minimum cost of 20.
//    Notice that there is a unique path between every pair of points.
//    Example 2:
//    Input: points = [[3,12],[-2,5],[-4,1]]
//    Output: 18
//    Constraints:
//    1 <= points.length <= 1000
//    -106 <= xi, yi <= 106
//    All pairs (xi, yi) are distinct.
public class SolutionDay45Second {
    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj[i][j] = dist;
                adj[j][i] = dist;
            }
        }
        int ans = 0;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        while (visited.size() != n) {
            int[] curr = pq.poll();
            int node = curr[1];
            if (visited.contains(node)) {
                continue;
            }
            ans += curr[0];
            visited.add(node);
            for (int k = 0; k < n; k++) {
                if (visited.contains(k)) {
                    continue;
                }
                pq.offer(new int[]{adj[node][k], k});
            }
        }
        return ans;
    }
}
