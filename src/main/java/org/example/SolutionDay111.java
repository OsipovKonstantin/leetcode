package org.example;

import java.util.ArrayList;
import java.util.List;

//    medium #string
//    Time complexity is O(n)
//    Space complexity is O(n)
//    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
//    Given a string s of '(' , ')' and lowercase English characters.
//    Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//    Formally, a parentheses string is valid if and only if:
//    It is the empty string, contains only lowercase characters, or
//    It can be written as AB (A concatenated with B), where A and B are valid strings, or
//    It can be written as (A), where A is a valid string.
//    Example 1:
//    Input: s = "lee(t(c)o)de)"
//    Output: "lee(t(c)o)de"
//    Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
//    Example 2:
//    Input: s = "a)b(c)d"
//    Output: "ab(c)d"
//    Example 3:
//    Input: s = "))(("
//    Output: ""
//    Explanation: An empty string is also valid.
public class SolutionDay111 {
    public static String minRemoveToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int counter = 0;
        List<Character> firstIteration = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                firstIteration.add(cs[i]);
                counter++;
            } else if (cs[i] == ')' && counter > 0) {
                firstIteration.add(cs[i]);
                counter--;
            } else if (cs[i] != ')') {
                firstIteration.add(cs[i]);
            }
        }
        List<Character> secondIteration = new ArrayList<>();
        for (int i = firstIteration.size() - 1; i >= 0; i--) {
            if (firstIteration.get(i) == '(' && counter > 0) {
                counter--;
            } else {
                secondIteration.add(firstIteration.get(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = secondIteration.size() - 1; i >= 0; i--) {
            ans.append(secondIteration.get(i));
        }
        return ans.toString();
    }
}
