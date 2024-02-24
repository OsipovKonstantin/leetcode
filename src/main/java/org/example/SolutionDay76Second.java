package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//    hard #union find (disjoint set) #TreeMap. Algorithm has insane speed comparative to another ones
//    Time complexity is O(m+n), where m is number of meetings and n is number of people
//    Space complexity is O(m+n)
//    https://leetcode.com/problems/find-all-people-with-secret
//    You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed
//    2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a
//    meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer
//    firstPerson.
//    Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then
//    shared every time a meeting takes place with a person that has the secret. More formally, for every meeting,
//    if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
//    The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in
//    other meetings within the same time frame.
//    Return a list of all the people that have the secret after all the meetings have taken place. You may return
//    the answer in any order.
//    Example 1:
//    Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
//    Output: [0,1,2,3,5]
//    Explanation:
//    At time 0, person 0 shares the secret with person 1.
//    At time 5, person 1 shares the secret with person 2.
//    At time 8, person 2 shares the secret with person 3.
//    At time 10, person 1 shares the secret with person 5.
//    Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
//    Example 2:
//    Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
//    Output: [0,1,3]
//    Explanation:
//    At time 0, person 0 shares the secret with person 3.
//    At time 2, neither person 1 nor person 2 know the secret.
//    At time 3, person 3 shares the secret with person 0 and person 1.
//    Thus, people 0, 1, and 3 know the secret after all the meetings.
//    Example 3:
//    Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
//    Output: [0,1,2,3,4]
//    Explanation:
//    At time 0, person 0 shares the secret with person 1.
//    At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
//    Note that person 2 can share the secret at the same time as receiving it.
//    At time 2, person 3 shares the secret with person 4.
//    Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
public class SolutionDay76Second {
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        UnionFind uf = new UnionFind(n);
        uf.unite(firstPerson, 0);

        Map<Integer, List<int[]>> timesMeetings = new TreeMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int t = meeting[2];
            timesMeetings.computeIfAbsent(t, key -> new ArrayList<>()).add(new int[]{x, y});
        }

        for (int t : timesMeetings.keySet()) {
            for (int[] meeting : timesMeetings.get(t)) {
                int x = meeting[0];
                int y = meeting[1];
                uf.unite(x, y);
            }

            for (int[] meeting : timesMeetings.get(t)) {
                int x = meeting[0];
                int y = meeting[1];
                if (!uf.connected(x, 0)) {
                    uf.reset(x);
                    uf.reset(y);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.connected(i, 0)) {
                ans.add(i);
            }
        }
        return ans;
    }
}

class UnionFind {
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