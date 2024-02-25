package org.example.datastructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ModifiedUnionFind {
    private int[] parent;
    private int[] rank;
    private Map<Integer, Set<Integer>> cols;
    private int colNumber;

    public ModifiedUnionFind(int rowNumber, int colNumber) {
        parent = new int[rowNumber * colNumber];
        rank = new int[rowNumber * colNumber];
        this.colNumber = colNumber;
        cols = new HashMap<>();
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                int index = i * colNumber + j;
                parent[index] = index;
                cols.computeIfAbsent(index, key -> new HashSet<>()).add(j);
            }
        }
    }

    public int find(int a) {
        if (parent[a] != a) parent[a] = find(parent[a]);
        return parent[a];
    }

    public boolean union(int a, int b) {
        int pA = find(a);
        int pB = find(b);
        if (pA != pB) {
            int coveredCols;
            if (rank[pA] > rank[pB]) {
                parent[pB] = pA;
                cols.get(pA).addAll(cols.get(pB));
                coveredCols = cols.get(pA).size();
            } else if (rank[pA] < rank[pB]) {
                parent[pA] = pB;
                cols.get(pB).addAll(cols.get(pA));
                coveredCols = cols.get(pB).size();
            } else {
                parent[pB] = pA;
                rank[pA]++;
                cols.get(pA).addAll(cols.get(pB));
                coveredCols = cols.get(pA).size();
            }
            return coveredCols == colNumber;
        }
        return false;
    }
}