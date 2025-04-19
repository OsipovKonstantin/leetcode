package org.example.java;

import java.util.ArrayDeque;
import java.util.Deque;

//    easy #stack
//    Time complexity is O(n), where n is the length of s string
//    Space complexity is O(n)
//    https://leetcode.com/problems/valid-parentheses
public class SolutionDay190Second {
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char cur = stack.pop();
                if (c == ')' && cur != '(') return false;
                if (c == ']' && cur != '[') return false;
                if (c == '}' && cur != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
