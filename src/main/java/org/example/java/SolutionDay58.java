package org.example.java;

import java.util.*;

//    medium (a very interesting task to complete) #sorting #hashmap
//    https://leetcode.com/problems/group-anagrams
//    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
//    all the original letters exactly once.
//    Example 1:
//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    Example 2:
//    Input: strs = [""]
//    Output: [[""]]
//    Example 3:
//    Input: strs = ["a"]
//    Output: [["a"]]
public class SolutionDay58 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        String[] sortedStrs = strs.clone();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            anagramMap.computeIfAbsent(new String(cs), key-> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
