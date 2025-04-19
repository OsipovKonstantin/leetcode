package org.example.java;

import java.util.ArrayDeque;
import java.util.Deque;

//    medium #mototonic decreasing stack
//    Deque is 2-4 times time faster than stack, so we use Deque with functionality of Stack
//    Time complexity O(n), space complexity O(n)
//    https://leetcode.com/problems/daily-temperatures
//    Given an array of integers temperatures represents the daily temperatures, return an array answer such that
//    answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
//    If there is no future day for which this is possible, keep answer[i] == 0 instead.
//    Example 1:
//    Input: temperatures = [73,74,75,71,69,72,76,73]
//    Output: [1,1,4,2,1,1,0,0]
//    Example 2:
//    Input: temperatures = [30,40,50,60]
//    Output: [1,1,1,0]
//    Example 3:
//    Input: temperatures = [30,60,90]
//    Output: [1,1,0]
public class SolutionDay52Second {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n];
        ans[n - 1] = 0;
        deque.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                deque.pop();
            }
            if (!deque.isEmpty() && temperatures[deque.peek()] > temperatures[i]) {
                ans[i] = deque.peek() - i;
            }
            deque.push(i);
        }
        return ans;
    }
}
