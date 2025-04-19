package org.example.java;

import java.util.*;

//    medium #Breadth-First Search (BFS). Time complexity is O(m*k), where m is number of flights, k is number of stops
//    Space complexity is O(n*m), where n is number of cities, m is number of flights
//    https://leetcode.com/problems/cheapest-flights-within-k-stops
//    There are n cities connected by some number of flights. You are given an array flights where flights[i] =
//    [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//    You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
//    If there is no such route, return -1.
//    Example 1:
//    Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
//    Output: 700
//    Explanation:
//    The graph is shown above.
//    The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
//    Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
//    Example 2:
//    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
//    Output: 200
//    Explanation:
//    The graph is shown above.
//    The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
//    Example 3:
//    Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
//    Output: 500
//    Explanation:
//    The graph is shown above.
//    The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
public class SolutionDay75Second {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] flight : flights)
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});
        int steps = 0;
        while (!q.isEmpty() && steps < k + 1) {
            steps++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int from = cur[0];
                int costFrom = cur[1];
                for (int[] next : graph.get(from)) {
                    int to = next[0];
                    int price = next[1];
                    if (costFrom + price < cost[to]) {
                        cost[to] = costFrom + price;
                        q.offer(new int[]{to, cost[to]});
                    }
                }
            }
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
