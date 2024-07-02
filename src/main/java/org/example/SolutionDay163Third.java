package org.example;

//    hard #UnionFind (disjoint set)
//    Time complexity is O((n+l)log(n+l)+(n+m)log(n+m)), where n is number of edges with type 3, l is number of edges
//    with type 1, m is number of edges with type 2
//    Space complexity is O(n+m+l)
//    https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable
//    Alice and Bob have an undirected graph of n nodes and three types of edges:
//    Type 1: Can be traversed by Alice only.
//    Type 2: Can be traversed by Bob only.
//    Type 3: Can be traversed by both Alice and Bob.
//    Given an array edges where edges[i] = [typei, ui, vi] represents a bidirectional edge of type typei between nodes
//    ui and vi, find the maximum number of edges you can remove so that after removing the edges, the graph can still
//    be fully traversed by both Alice and Bob. The graph is fully traversed by Alice and Bob if starting from any
//    node, they can reach all other nodes.
//    Return the maximum number of edges you can remove, or return -1 if Alice and Bob cannot fully traverse the graph.
//    Example 1:
//    Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
//    Output: 2
//    Explanation: If we remove the 2 edges [1,1,2] and [1,1,3]. The graph will still be fully traversable by Alice and
//    Bob. Removing any additional edge will not make it so. So the maximum number of edges we can remove is 2.
//    Example 2:
//    Input: n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
//    Output: 0
//    Explanation: Notice that removing any edge will not make the graph fully traversable by Alice and Bob.
//    Example 3:
//    Input: n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
//    Output: -1
//    Explanation: In the current graph, Alice cannot reach node 4 from the other nodes. Likewise, Bob cannot reach 1.
//    Therefore it's impossible to make the graph fully traversable.
public class SolutionDay163Third {
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);
        UnionFind ufCommon = new UnionFind(n);

        int usedEdges = 0;

        // Process type 3 edges (both Alice and Bob)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufCommon.unite(edge[1] - 1, edge[2] - 1)) {
                    ufAlice.unite(edge[1] - 1, edge[2] - 1);
                    ufBob.unite(edge[1] - 1, edge[2] - 1);
                    usedEdges++;
                }
            }
        }

        // Process type 1 edges (Alice only)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.unite(edge[1] - 1, edge[2] - 1)) {
                    usedEdges++;
                }
            }
        }

        // Process type 2 edges (Bob only)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufBob.unite(edge[1] - 1, edge[2] - 1)) {
                    usedEdges++;
                }
            }
        }

        // Check if the graph is fully traversable by both Alice and Bob
        if (ufAlice.isConnected() && ufBob.isConnected()) {
            return edges.length - usedEdges;
        } else {
            return -1;
        }
    }

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean unite(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }

        public boolean isConnected() {
            return count == 1;
        }
    }
}
