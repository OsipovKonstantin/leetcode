package org.example.java;

import java.util.*;

//    medium (really hard because of a lot of themes in solution) #graph #depth first search #breadth first search
//    Time and space complexity is O(n)
//    https://leetcode.com/problems/most-profitable-path-in-a-tree
public class SolutionDay173Second {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            graph.computeIfAbsent(edges[i][0], key -> new ArrayList<>()).add(edges[i][1]);
            graph.computeIfAbsent(edges[i][1], key -> new ArrayList<>()).add(edges[i][0]);
        }
        List<Integer> bPath = new ArrayList<>();
        bPath.add(bob);
        Set<Integer> seen = new HashSet<>();
        seen.add(bob);
        traverse(bPath, graph, bob, seen);
        //converting bob path (bPath) from list to map, where key is node and value is time, when bob reached node
        Map<Integer, Integer> bobTime = new HashMap<>();
        for (int i = 0; i < bPath.size(); i++) {
            bobTime.put(bPath.get(i), i);
        }
        //bfs for searching the most profitable path for alice from node 0 to leaf
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, amount[0]});
        seen.clear();
        seen.add(0);
        int time = 0;
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int neighbours = 0;
                int[] cur = q.poll();
                int curNode = cur[0];
                int curProfit = cur[1];
                for (int element : graph.get(curNode)) {
                    if (seen.contains(element)) continue;
                    neighbours++;
                    int nodeProfit;
                    int bTime = bobTime.getOrDefault(element, Integer.MAX_VALUE);
                    if (bTime > time) nodeProfit = amount[element];
                    else if (bTime == time) nodeProfit = amount[element] / 2;
                    else nodeProfit = 0;
                    q.offer(new int[]{element, curProfit + nodeProfit});
                    seen.add(element);
                }
                if (neighbours == 0) ans = Math.max(ans, curProfit);
            }
        }
        return ans;
    }

    //dfs for searching path for bob (list bPath)
    public static boolean traverse(List<Integer> bPath, Map<Integer, List<Integer>> graph, int cur, Set<Integer> seen) {
        if (cur == 0) return true;
        for (int element : graph.get(cur)) {
            if (seen.contains(element)) continue;
            bPath.add(element);
            seen.add(element);
            if (traverse(bPath, graph, element, seen)) return true;
            else {
                bPath.remove(bPath.size() - 1);
                seen.remove(element);
            }
        }
        return false;
    }
}
