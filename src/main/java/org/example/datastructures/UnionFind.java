package org.example.datastructures;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void unite(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX != pY) {
            if (rank[pX] > rank[pY]) {
                parent[pY] = pX;
            } else if (rank[pX] < rank[pY]) {
                parent[pX] = pY;
            } else {
                parent[pY] = pX;
                rank[pX]++;
            }
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }

    public void reset(int x) {
        parent[x] = x;
        rank[x] = 0;
    }
}
