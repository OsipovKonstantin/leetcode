package org.example.java;

//    medium #counting #graph Construction of graph is 7 time slower than solution provided below
//    Time complexity is O(n^2+m), where n is number of cities, m is number of roads
//    Space complexity is O(n^2)
//    https://leetcode.com/problems/maximal-network-rank
//    There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi]
//    indicates that there is a bidirectional road between cities ai and bi.
//    The network rank of two different cities is defined as the total number of directly connected roads to either
//    city. If a road is directly connected to both cities, it is only counted once.
//    The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
//    Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
//    Example 1:
//    Input: n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
//    Output: 4
//    Explanation: The network rank of cities 0 and 1 is 4 as there are 4 roads that are connected to either 0 or 1.
//    The road between 0 and 1 is only counted once.
//    Example 2:
//    Input: n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
//    Output: 5
//    Explanation: There are 5 roads that are connected to cities 1 or 2.
//    Example 3:
//    Input: n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
//    Output: 5
//    Explanation: The network rank of 2 and 5 is 5. Notice that all the cities do not have to be connected.
public class SolutionDay56Second {
    public static int maximalNetworkRank(int n, int[][] roads) {
        if (roads.length == 0)
            return 0;

        boolean[][] commonRoad = new boolean[n][n];
        int[] numOfRoads = new int[n];
        for (int[] road : roads) {
            int c1 = road[0];
            int c2 = road[1];
            numOfRoads[c1]++;
            numOfRoads[c2]++;
            commonRoad[c1][c2] = true;
            commonRoad[c2][c1] = true;
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                ans = Math.max(ans, numOfRoads[i] + numOfRoads[j] - (commonRoad[i][j] ? 1 : 0));
        return ans;
    }
}
