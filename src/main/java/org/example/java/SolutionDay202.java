package org.example.java;

import java.util.Arrays;

//    hard (really easy) #sorting
//    Time complexity is O(nlogn), where n is the size of weigths array
//    Space complexity is O(n)
//    https://leetcode.com/problems/put-marbles-in-bags
public class SolutionDay202 {
    public static long putMarbles(int[] weights, int k) {
        int len = weights.length - 1;
        int[] score = new int[len];
        for (int i = 0; i < len; i++) {
            score[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(score);
        long ans = 0;
        for (int i = 0; i < k - 1; i++) {
            ans += score[len - i - 1] - score[i];
        }
        return ans;
    }
}
