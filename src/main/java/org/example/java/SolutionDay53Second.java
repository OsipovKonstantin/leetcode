package org.example.java;

import java.util.Arrays;

//    medium #greedy (brilliant solution!) We sort 1 time then traverse 1 time. Time complexity O(n*logn)
//    because sorting require n*logn operations and traverse require n. Space complexity O(1)
//    https://leetcode.com/problems/maximum-length-of-pair-chain
//    You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
//    A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
//    Return the length longest chain which can be formed.
//    You do not need to use up all the given intervals. You can select pairs in any order.
//    Example 1:
//    Input: pairs = [[1,2],[2,3],[3,4]]
//    Output: 2
//    Explanation: The longest chain is [1,2] -> [3,4].
//    Example 2:
//    Input: pairs = [[1,2],[7,8],[4,5]]
//    Output: 3
//    Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
public class SolutionDay53Second {
    public static int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 1) {
            return 1;
        }
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int ans = 1;
        int end = pairs[0][1];
        for (int i = 0; i < n; i++) {
            if (end < pairs[i][0]) {
                end = pairs[i][1];
                ans++;
            }
        }
        return ans;
    }
}
