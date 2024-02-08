package org.example;

import java.util.LinkedList;
import java.util.Queue;

//    medium #breadth first search (BFS) with memoization. It is very fast and approach (BFS+memoization) is brilliant!
//    https://leetcode.com/problems/perfect-squares
//    Given an integer n, return the least number of perfect square numbers that sum to n.
//    A perfect square is an integer that is the square of an integer; in other words, it is the product of some
//    integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
//    Example 1:
//    Input: n = 12
//    Output: 3
//    Explanation: 12 = 4 + 4 + 4.
//    Example 2:
//    Input: n = 13
//    Output: 2
//    Explanation: 13 = 4 + 9.
public class SolutionDay60Third {
    public static int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int counter = -1;
        boolean[] memo = new boolean[n + 1];
        while (!q.isEmpty()) {
            int size = q.size();
            counter++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                int max = (int) Math.pow(cur, 0.5);
                for (int j = 1; j <= max; j++) {
                    int next = cur - j * j;
                    if (memo[next]) continue;
                    if (next > 0) {
                        q.offer(next);
                        memo[next] = true;
                    } else if (next == 0) return counter + 1;
                }
            }
        }
        return -1;
    }
}