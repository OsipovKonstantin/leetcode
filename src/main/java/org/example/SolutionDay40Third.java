package org.example;

import java.util.Stack;

//    medium (really hard or original). #stack #set. We use stack + visited (set or boolean[]) + last index of chars
//    (int[]) to solve task
//    https://leetcode.com/problems/remove-duplicate-letters
//    Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure
//    your result is the smallest in lexicographical order among all possible results.
//    Example 1:
//    Input: s = "bcabc"
//    Output: "abc"
//    Example 2:
//    Input: s = "cbacdcbc"
//    Output: "acdb"
public class SolutionDay40Third {
    public static String removeDuplicateLetters(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int[] lastIndexes = new int[26];
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            lastIndexes[cs[i] - 'a'] = i;
        }
        for (int j = 0; j < n; j++) {
            if (visited[cs[j] - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && cs[j] < stack.peek() && j < lastIndexes[stack.peek() - 'a']) {
                int poppedInt = stack.pop() - 'a';
                visited[poppedInt] = false;
            }

            stack.push(cs[j]);
            visited[cs[j] - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
