package org.example.java;

import java.util.*;

//    hard. Breadth-First Search. First approach (slower than second 10 times, but it is easy to apply).
//    Steps 1. Map busStop - bus, 2. use queue for iterating buses from source stop to target
//    https://leetcode.com/problems/bus-routes
//    You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats
//    forever.
//    For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 ->
//    5 -> 7 -> 1 -> ... forever.
//    You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop
//    target. You can travel between bus stops by buses only.
//    Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
//    Example 1:
//    Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//    Output: 2
//    Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
//    Example 2:
//    Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//    Output: -1
public class SolutionDay26Third {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                List<Integer> buses = map.getOrDefault(stop, new ArrayList<>());
                buses.add(i);
                map.put(stop, buses);
            }
        }
        if (!map.containsKey(source) || !map.containsKey(target)) {
            return -1;
        }
        Queue<Integer> curr = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int ans = 1;
        for (int bus : map.get(source)) {
            curr.add(bus);
            visited.add(bus);
        }
        while (!curr.isEmpty()) {
            int size = curr.size();
            for (int i = 0; i < size; i++) {
                int currBus = curr.remove();
                for (int stop : routes[currBus]) {
                    if (stop == target) {
                        return ans;
                    }
                    for (int nextBus : map.get(stop)) {
                        if (!visited.contains(nextBus)) {
                            visited.add(nextBus);
                            curr.add(nextBus);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}