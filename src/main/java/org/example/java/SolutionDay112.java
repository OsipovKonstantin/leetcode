package org.example.java;

import java.util.ArrayList;
import java.util.List;

//    easy #string
//    Time complexity is O(n^2)
//    Space complexity is O(n)
//    https://leetcode.com/problems/make-the-string-great
//    Given a string s of lower and upper case English letters.
//    A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
//    0 <= i <= s.length - 2
//    s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
//    To make the string good, you can choose two adjacent characters that make the string bad and remove them. You
//    can keep doing this until the string becomes good.
//    Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
//    Notice that an empty string is also good.
//    Example 1:
//    Input: s = "leEeetcode"
//    Output: "leetcode"
//    Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced
//    to "leetcode".
//    Example 2:
//    Input: s = "abBAcC"
//    Output: ""
//    Explanation: We have many possible scenarios, and all lead to the same answer. For example:
//    "abBAcC" --> "aAcC" --> "cC" --> ""
//    "abBAcC" --> "abBA" --> "aA" --> ""
//    Example 3:
//    Input: s = "s"
//    Output: "s"
public class SolutionDay112 {
    public static String makeGood(String s) {
        int n = s.length();
        List<Character> next = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            next.add(s.charAt(i));
        }
        List<Character> prev = new ArrayList<>();
        boolean found = true;
        while (found) {
            found = false;
            prev = next;
            next = new ArrayList<>();
            for (int i = 0; i < prev.size(); i++) {
                if (i == prev.size() - 1) next.add(prev.get(i));
                else if (Character.toUpperCase(prev.get(i)) == Character.toUpperCase(prev.get(i + 1))
                        && prev.get(i) != prev.get(i + 1)) {
                    i++;
                    found = true;
                } else {
                    next.add(prev.get(i));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Character character : next) {
            ans.append(character);
        }
        return ans.toString();
    }
}
