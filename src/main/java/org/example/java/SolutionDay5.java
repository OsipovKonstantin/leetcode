package org.example.java;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//    https://leetcode.com/problems/destination-city
//    You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi.
//    Return the destination city, that is, the city without any path outgoing to another city.
//    It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
//    Example 1:
//    Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
//    Output: "Sao Paulo"
//    Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
//    Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
//    Example 3:
//    Input: paths = [["A","Z"]]
//    Output: "Z"
public class SolutionDay5 {
    public static String destCity(List<List<String>> paths) {
        Set<String> pathCount = new HashSet<>();
        for (List<String> path : paths) {
            pathCount.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!pathCount.contains(path.get(1)))
                return path.get(1);
        }
        return "";
    }
}
