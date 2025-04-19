package org.example.java;

import java.util.*;

//    hard (really very hard with short code)
//    #Depth First Search (recursive). We wrote path backward. Points where we stuck is final
//    points of route, so we just write them first then add point in backward direction
//    https://leetcode.com/problems/reconstruct-itinerary
//    You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival
//    airports of one flight. Reconstruct the itinerary in order and return it.
//    All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there
//    are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read
//    as a single string.
//    For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
//    You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
//    Example 1:
//    Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//    Output: ["JFK","MUC","LHR","SFO","SJC"]
//    Example 2:
//    Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//    Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//    Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical
//    order.
public class SolutionDay45Third {
    private static Map<String, PriorityQueue<String>> targets;
    private static List<String> route;

    public static List<String> findItinerary(List<List<String>> tickets) {
        targets = new HashMap<>();
        route = new ArrayList<>();
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>()).offer(ticket.get(1));
        }
        dfs("JFK");
        return route;
    }

    private static void dfs(String airport) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            dfs(targets.get(airport).poll());
        }
        route.add(0, airport);
    }
}
