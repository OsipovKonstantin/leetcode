package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

//    medium #deque. Time complexity is O(n), space complexity is O(n)
//    https://leetcode.com/problems/asteroid-collision
//    We are given an array asteroids of integers representing asteroids in a row.
//    For each asteroid, the absolute value represents its size, and the sign represents its direction (positive
//    meaning right, negative meaning left). Each asteroid moves at the same speed.
//    Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode.
//    If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//    Example 1:
//    Input: asteroids = [5,10,-5]
//    Output: [5,10]
//    Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//    Example 2:
//    Input: asteroids = [8,-8]
//    Output: []
//    Explanation: The 8 and -8 collide exploding each other.
//    Example 3:
//    Input: asteroids = [10,2,-5]
//    Output: [10]
//    Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
public class SolutionDay67Second {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (deque.isEmpty() || deque.peekLast() < 0 || asteroid > 0)
                deque.offerLast(asteroid);
            else {
                while (!deque.isEmpty() && deque.peekLast() > 0 && deque.peekLast() < Math.abs(asteroid))
                    deque.pollLast();
                if (deque.isEmpty() || deque.peekLast() < 0) deque.offerLast(asteroid);
                else if (deque.peekLast() == Math.abs(asteroid)) deque.pollLast();
            }
        }
        int ansSize = deque.size();
        int[] ans = new int[ansSize];
        for (int i = 0; i < ansSize; i++) {
            ans[i] = deque.pollFirst();
        }
        return ans;
    }
}
