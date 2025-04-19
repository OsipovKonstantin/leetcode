package org.example.java;

//    medium #sliding window
//    Time complexity is O(n)
//    Space complexity is O(n)
//    https://leetcode.com/problems/grumpy-bookstore-owner
//    There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the
//    store. You are given an integer array customers of length n where customers[i] is the number of the customer that
//    enters the store at the start of the ith minute and all those customers leave after the end of that minute.
//    On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the
//    bookstore owner is grumpy during the ith minute, and is 0 otherwise.
//    When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
//    The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but
//    can only use it once.
//    Return the maximum number of customers that can be satisfied throughout the day.
//    Example 1:
//    Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//    Output: 16
//    Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
//    The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
//    Example 2:
//    Input: customers = [1], grumpy = [0], minutes = 1
//    Output: 1
public class SolutionDay159 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;
        int n = customers.length;
        int[] notSatisfied = new int[n];
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) satisfied += customers[i];
            else notSatisfied[i] = customers[i];
        }
        int maxNotSatisfied = 0;
        int curNotSatisfied = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (end - start >= minutes) {
                curNotSatisfied -= notSatisfied[start];
                start++;
            }
            curNotSatisfied += notSatisfied[end];
            maxNotSatisfied = Math.max(maxNotSatisfied, curNotSatisfied);
        }
        return satisfied + maxNotSatisfied;
    }
}
