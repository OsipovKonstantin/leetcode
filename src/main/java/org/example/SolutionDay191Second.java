package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

//    medium #string #queue #stack
//    Time complexity is O(n), where n is the length of path string
//    Space complexity is O(n)
//    https://leetcode.com/problems/simplify-path
public class SolutionDay191Second {
    public static String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!part.equals("") && !part.equals(".")) {
                stack.push(part);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append("/").append(stack.pollLast());
        }
        return ans.length() == 0 ? "/" : ans.toString();
    }
}
