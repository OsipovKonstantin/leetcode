package org.example.java;

//    easy #graph. Time complexity is O(n+m), where n is number of citizens and m is number of trust pairs.
//    Space complexity is O(n)
//    https://leetcode.com/problems/find-the-town-judge
//    In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the
//    town judge.
//    If the town judge exists, then:
//    The town judge trusts nobody.
//    Everybody (except for the town judge) trusts the town judge.
//    There is exactly one person that satisfies properties 1 and 2.
//    You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person
//    labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
//    Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
//    Example 1:
//    Input: n = 2, trust = [[1,2]]
//    Output: 2
//    Example 2:
//    Input: n = 3, trust = [[1,3],[2,3]]
//    Output: 3
//    Example 3:
//    Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//    Output: -1
public class SolutionDay74Second {
    public static int findJudge(int n, int[][] trust) {
        int[] incoming = new int[n + 1];
        int[] outcoming = new int[n + 1];
        for (int[] pair : trust) {
            int who = pair[0];
            int whom = pair[1];
            incoming[whom]++;
            outcoming[who]++;
        }
        for (int i = 1; i <= n; i++)
            if (incoming[i] == n - 1 && outcoming[i] == 0) return i;
        return -1;
    }
}
