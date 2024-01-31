package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//    hard #Breadth First Search. Not very fast solution compare to dynamic programming, but I decided to implement it
//    Tricks in this approach, that improve time complexity: 1. put visited.contains and visited.add before adding
//    element to deque. Otherwise, we add them to deque, and it will be much slower because we need to traverse them
//    afterward (Time Limit Exceeded on leetcode)
//    https://leetcode.com/problems/frog-jump
//    A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may
//    not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//    Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river
//    by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
//    If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only
//    jump in the forward direction.
//    Example 1:
//    Input: stones = [0,1,3,5,6,8,12,17]
//    Output: true
//    Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd
//    stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to
//    the 8th stone.
//    Example 2:
//    Input: stones = [0,1,2,3,4,8,9,11]
//    Output: false
//    Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
public class SolutionDay52Sixth {
    public static boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        if (stones.length == 2) {
            return true;
        }
        int n = stones.length;
        int lastStone = stones[n - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(stones[i]);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        deque.offer(new int[]{1, 1});
        while (deque.size() > 0) {
            int size = deque.size();
            int[] cur = deque.poll();
            int curStep = cur[0];
            int curVal = cur[1];

            for (int i = -1; i <= 1; i++) {
                int nextStep = curStep + i;
                int nextVal = curVal + curStep + i;
                if (nextStep < 1) continue;
                if (!visited.contains(nextStep + " " + (nextVal)) && set.contains(nextVal)) {
                    if (nextVal == lastStone) return true;
                    deque.offer(new int[]{nextStep, nextVal});
                    visited.add(nextStep + " " + (nextVal));
                }
            }
        }
        return false;
    }
}
