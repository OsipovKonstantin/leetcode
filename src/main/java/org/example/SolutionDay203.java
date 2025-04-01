package org.example;

//    medium #prefix sum
//    Time complexity is O(n), where n is the length of questions array
//    Space complexity is O(n)
//    https://leetcode.com/problems/solving-questions-with-brainpower
public class SolutionDay203 {
    public static long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] prefixSum = new long[len];
        for (int i = len - 1; i >= 0; i--) {
            long cur = questions[i][0];
            long skip = questions[i][1];
            long prevOptimal = i + skip + 1 >= len ? 0 : prefixSum[i + (int) skip + 1];
            prefixSum[i] = Math.max(i + 1 == len ? 0 : prefixSum[i + 1], cur + prevOptimal);
        }
        return prefixSum[0];
    }
}
