package org.example;

import java.util.Arrays;

//    medium #dynamic programming. Recursive approach with memoization
//    https://leetcode.com/problems/soup-servings
//    There are two types of soup: type A and type B. Initially, we have n ml of each type of soup. There are four
//    kinds of operations:
//    Serve 100 ml of soup A and 0 ml of soup B,
//    Serve 75 ml of soup A and 25 ml of soup B,
//    Serve 50 ml of soup A and 50 ml of soup B, and
//    Serve 25 ml of soup A and 75 ml of soup B.
//    When we serve some soup, we give it to someone, and we no longer have it. Each turn, we will choose from the four
//    operations with an equal probability 0.25. If the remaining volume of soup is not enough to complete the
//    operation, we will serve as much as possible. We stop once we no longer have some quantity of both types of soup.
//    Note that we do not have an operation where all 100 ml's of soup B are used first.
//    Return the probability that soup A will be empty first, plus half the probability that A and B become empty at
//    the same time. Answers within 10-5 of the actual answer will be accepted.
//    Example 1:
//    Input: n = 50
//    Output: 0.62500
//    Explanation: If we choose the first two operations, A will become empty first.
//    For the third operation, A and B will become empty at the same time.
//    For the fourth operation, B will become empty first.
//    So the total probability of A becoming empty first plus half the probability that A and B become empty at the
//    same time, is 0.25 * (1 + 1 + 0.5 + 0) = 0.625.
//    Example 2:
//    Input: n = 100
//    Output: 0.71875
public class SolutionDay63Second {
    public static double soupServings(int n) {
        int m = n / 25 + (n % 25 == 0 ? 0 : 1);
        if (m > 200) return 1;
        float[][] memo = new float[m + 1][m + 1];
        for (float[] row : memo) Arrays.fill(row, -1);
        for (int i = 1; i < m + 1; i++) {
            memo[0][i] = 1;
            memo[i][0] = 0;
        }
        memo[0][0] = (float) 0.5;
        return traverse(memo, m, m);
    }

    private static float traverse(float[][] memo, int leftA, int leftB) {
        if (memo[leftA][leftB] != -1) return memo[leftA][leftB];
        float ans = 0;
        for (int soupA = 4; soupA >= 1; soupA--) {
            int soupB = 4 - soupA;
            int nextLeftA = leftA - soupA;
            int nextLeftB = leftB - soupB;
            ans += traverse(memo, Math.max(nextLeftA, 0), Math.max(nextLeftB, 0));
        }
        memo[leftA][leftB] = ans / 4;
        return memo[leftA][leftB];
    }
}
