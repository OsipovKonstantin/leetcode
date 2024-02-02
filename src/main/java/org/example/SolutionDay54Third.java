package org.example;

import java.util.PriorityQueue;

//    medium #PriorityQueue #counter
//    https://leetcode.com/problems/reorganize-string
//    Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//    Return any possible rearrangement of s or return "" if not possible.
//    Example 1:
//    Input: s = "aab"
//    Output: "aba"
//    Example 2:
//    Input: s = "aaab"
//    Output: ""
public class SolutionDay54Third {
    public static String reorganizeString(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] freq = new int[26];
        for (char c : cs) {
            freq[c - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[1] - p1[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i + 'a', freq[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            char firstChar = (char) first[0];
            int firstFreq = first[1];
            if (sb.length() == 0 || firstChar != sb.charAt(sb.length() - 1)) {
                sb.append(firstChar);
                firstFreq--;
                if (firstFreq > 0) {
                    pq.offer(new int[]{firstChar, firstFreq});
                }
                continue;
            }
            if (pq.isEmpty()) {
                return "";
            }
            int[] second = pq.poll();
            char secondChar = (char) second[0];
            int secondFreq = second[1];
            sb.append(secondChar);
            secondFreq--;
            if (secondFreq > 0) {
                pq.offer(new int[]{secondChar, secondFreq});
            }
            pq.offer(new int[]{firstChar, firstFreq});
        }
        return sb.toString();
    }
}
