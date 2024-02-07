package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//    medium #stream #counting
//    https://leetcode.com/problems/sort-characters-by-frequency
//    Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a
//    character is the number of times it appears in the string.
//    Return the sorted string. If there are multiple answers, return any of them.
//    Example 1:
//    Input: s = "tree"
//    Output: "eert"
//    Explanation: 'e' appears twice while 'r' and 't' both appear once.
//    So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//    Example 2:
//    Input: s = "cccaaa"
//    Output: "aaaccc"
//    Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
//    Note that "cacaca" is incorrect, as the same characters must be together.
//    Example 3:
//    Input: s = "Aabb"
//    Output: "bbAa"
//    Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
//    Note that 'A' and 'a' are treated as two different characters.
public class SolutionDay59Third {
    public static String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : cs)
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        return freq.entrySet().stream()
                .sorted((es1, es2) -> es2.getValue() - es1.getValue())
                .map(es -> es.getKey().toString().repeat(es.getValue()))
                .collect(Collectors.joining());
    }
}
