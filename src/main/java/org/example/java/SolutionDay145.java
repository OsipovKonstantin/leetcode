package org.example.java;

import java.util.PriorityQueue;
import java.util.Queue;

//    medium #priority queue (not very intuitive task)
//    Time complexity is O(nlogn)
//    Space complexity is O(n)
//    https://leetcode.com/problems/hand-of-straights
//    Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size
//    groupSize, and consists of groupSize consecutive cards.
//    Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return
//    true if she can rearrange the cards, or false otherwise.
//    Example 1:
//    Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//    Output: true
//    Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
//    Example 2:
//    Input: hand = [1,2,3,4,5], groupSize = 4
//    Output: false
//    Explanation: Alice's hand can not be rearranged into groups of 4.
public class SolutionDay145 {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : hand) pq.offer(num);
        while (!pq.isEmpty()) {
            int val = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (!pq.remove(val + i)) return false;
            }
        }
        return true;
    }
}
