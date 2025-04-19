package org.example.java;

import java.util.HashMap;
import java.util.Map;

//    easy #hash table #string
//    Time complexity is O(n+m), where n and m is the lengths of pattern and s string respectively
//    Space complexity is O(n+m) due to the split() method and the length of arr array
//    https://leetcode.com/problems/word-pattern
public class SolutionDay185Third {
    public static boolean wordPattern(String pattern, String s) {
        String[] arr = new String[26];
        String[] words = s.split(" ");
        int len = words.length;
        if (pattern.length() != len) return false;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int letter = pattern.charAt(i) - 'a';
            String word = words[i];
            if (map.containsKey(word) && !map.get(word).equals(letter)) return false;
            if (arr[letter] == null) {
                arr[letter] = word;
                map.put(word, letter);
            } else {
                if (!arr[letter].equals(words[i])) return false;
            }
        }
        return true;
    }
}
