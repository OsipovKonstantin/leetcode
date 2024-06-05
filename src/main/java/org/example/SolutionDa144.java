package org.example;

import java.util.ArrayList;
import java.util.List;

//    easy #string
//    Time complexity is O((n+26)*m), where n is avarage length of word in array words, m is number of words
//    Space complexity is O(26+r), where r is shortest word in array words
//    https://leetcode.com/problems/find-common-characters
//    Given a string array words, return an array of all characters that show up in all strings within the words
//    (including duplicates). You may return the answer in any order.
//    Example 1:
//    Input: words = ["bella","label","roller"]
//    Output: ["e","l","l"]
//    Example 2:
//    Input: words = ["cool","lock","cook"]
//    Output: ["c","o"]
public class SolutionDa144 {
        public static List<String> commonChars(String[] words) {
            int n = words.length;
            int[] curChars = new int[26];
            for(char c: words[0].toCharArray()) {
                curChars[c-'a']++;
            }
            for(int i = 1; i < n; i++) {
                int[] nextChars = new int[26];
                for(char c: words[i].toCharArray()) {
                    nextChars[c-'a']++;
                }
                for(int j = 0; j < 26; j++) {
                    curChars[j] = Math.min(curChars[j], nextChars[j]);
                }
            }
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                char c = (char)(i+'a');
                for(int j = 0; j < curChars[i]; j++) {
                    ans.add(String.valueOf(c));
                }
            }
            return ans;
        }
}
