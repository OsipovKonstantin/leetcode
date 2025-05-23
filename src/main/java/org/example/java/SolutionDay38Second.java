package org.example.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//    easy #map #set
//    https://leetcode.com/problems/unique-number-of-occurrences
//    Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or
//    false otherwise.
//    Example 1:
//    Input: arr = [1,2,2,1,1,3]
//    Output: true
//    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences
//    Example 2:
//    Input: arr = [1,2]
//    Output: false
//    Example 3:
//    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
//    Output: true
public class SolutionDay38Second {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int el : arr) {
            occurrences.put(el, occurrences.getOrDefault(el, 0) + 1);
        }
        Set<Integer> unique = new HashSet<>();
        for (int val : occurrences.values()) {
            if (unique.contains(val)) {
                return false;
            }
            unique.add(val);
        }
        return true;
    }
}